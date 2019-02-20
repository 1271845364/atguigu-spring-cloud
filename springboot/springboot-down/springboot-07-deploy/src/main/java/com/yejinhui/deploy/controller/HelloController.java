package com.yejinhui.deploy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ye.jinhui
 * @project springboot-07-deploy
 * @description
 * @create 2018/11/9 14:33
 */
@Controller
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "hello";
    }

}
