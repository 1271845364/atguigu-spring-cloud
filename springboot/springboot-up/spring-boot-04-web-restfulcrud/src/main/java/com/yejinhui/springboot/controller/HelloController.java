package com.yejinhui.springboot.controller;


import com.yejinhui.springboot.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * @author ye.jinhui
 * @version v1.0.0
 * @date 2018/9/19 16:30
 */
@Controller
public class HelloController {

//    @RequestMapping({"/","/index.html"})
//    public String index() {
//        return "index";
//    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(@RequestParam("user") String user,Date date) {
        if("aaa".equals(user)) {
            throw new UserNotExistException();
        }
        System.out.println("asas");
        return "Hello World";
    }

    //查询用户数据，在页面展示
    @RequestMapping("/success")
    public String success(Map<String,Object> map) {
        map.put("hello","<h1>你好</h1>");
        map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));
        //classpath:/templates/success.html
        return "success";
    }
}
