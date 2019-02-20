package com.yejinhui.springboot.controller;

import com.yejinhui.starter.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ye.jinhui
 * @version v1.0.0
 * @date 2018/10/2 16:29
 */
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/hello")
    public String hello() {
        return helloService.sayHelloYejinhui("haha");
    }

}
