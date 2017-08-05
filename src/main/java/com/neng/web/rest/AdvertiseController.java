package com.neng.web.rest;

import com.neng.config.ApiConf;
import com.neng.pojo.Advertise;
import com.neng.pojo.User;
import com.neng.repository.AdvertiseRepository;
import com.neng.service.inner.AdvertiseService;
import com.neng.service.inner.UserService;
import com.neng.utils.PageWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by nengneng on 2017/8/5.
 */

@Controller
public class AdvertiseController {

    private static final Logger log = LoggerFactory.getLogger(AdminController.class);

    private UserService userService;

    private AdvertiseService advertiseService;

    private AdvertiseRepository advertiseRepository;


    @Autowired
    public AdvertiseController(UserService userService,
                            AdvertiseService advertiseService,
                               AdvertiseRepository advertiseRepository) {
        this.advertiseService = advertiseService;
        this.userService = userService;
        this.advertiseRepository = advertiseRepository;
    }


    /**
     * 获取广告列表
     * @param pageable
     * @param model
     * @return
     */
    @GetMapping(value = ApiConf.listAdvertises, produces = MediaType.APPLICATION_JSON_VALUE)
    public String list(@PageableDefault(value = 5, sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable, Model model) {

        Page<Advertise> advertises = advertiseService.list(pageable);
        PageWrapper<Advertise> page = new PageWrapper<Advertise>(advertises, ApiConf.advertises);
        model.addAttribute(ApiConf.view_content, ApiConf.advertise_list);
        model.addAttribute(ApiConf.breadCump, ApiConf.advertise);
        model.addAttribute(ApiConf.page,page);
        return ApiConf.index;

    }

    /**
     * 添加广告
     * @param advertise
     * @return
     */
    @PostMapping(value = ApiConf.saveAdvertise, produces = MediaType.APPLICATION_JSON_VALUE)
    public String add(Advertise advertise) {
        advertiseRepository.save(advertise);
        return "redirect:/" + ApiConf.listAdvertises;

    }

}
