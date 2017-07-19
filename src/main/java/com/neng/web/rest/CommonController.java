package com.neng.web.rest;

import com.neng.config.ApiConf;
import com.neng.pojo.config.Api;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by nengneng on 2017/6/5.
 */

@Controller
public class CommonController {


    @GetMapping("/index")
    public String admin(Model model){

        model.addAttribute(ApiConf.view_content, ApiConf.fontend);
        model.addAttribute(ApiConf.breadCump, ApiConf.index);
        return "index";
    }

    @GetMapping("/users")
    public String users(Model model){

        model.addAttribute(ApiConf.view_content, ApiConf.user_list);
        model.addAttribute(ApiConf.breadCump, ApiConf.user);
        return "index";
    }

    @GetMapping("/orders")
    public String orders(Model model){

        model.addAttribute(ApiConf.view_content, ApiConf.order_list);
        model.addAttribute(ApiConf.breadCump, ApiConf.order);
        return "index";
    }

    @GetMapping("/needs")
    public String needs(Model model){

        model.addAttribute(ApiConf.view_content, ApiConf.need_list);
        model.addAttribute(ApiConf.breadCump, ApiConf.need);
        return "index";
    }

    @GetMapping("/main")
    public String main(){
        return "admin/main";
    }

    @GetMapping("/signIn")
    public String signIn(){
        return "admin/signIn";
    }

}
