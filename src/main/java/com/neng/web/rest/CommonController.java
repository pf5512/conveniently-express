package com.neng.web.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by nengneng on 2017/6/5.
 */

@Controller
public class CommonController {


    @GetMapping("/index")
    public String admin(){
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
