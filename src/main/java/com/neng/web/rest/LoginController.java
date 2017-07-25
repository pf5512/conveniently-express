package com.neng.web.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by nengneng on 2017/7/20.
 */
@Controller
public class LoginController {


    @GetMapping("/login")
    public String login(){

        return "login";
    }

    @GetMapping("/403")
    public String denied(){

        return "403";
    }
}
