package com.yejinhui.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ye.jinhui
 * @version v1.0.0
 * @date 2018/9/28 11:25
 */
@Controller
public class HelloController {

    @GetMapping
    public String hello(Model model) {
        model.addAttribute("msg","你好");
        return "success";
    }

}
