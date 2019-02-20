package com.yejinhui.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author ye.jinhui
 * @version v1.0.0
 * @date 2018/9/24 12:52
 */
@Controller
public class LoginController {

//    @PutMapping
//    @DeleteMapping
//    @GetMapping
    @PostMapping(value = "/user/login")
//    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session) {
        if(!StringUtils.isEmpty(username) && "123456".equals(password)) {
            session.setAttribute("loginUser",username);
            //登录成功，防止表单重复提交，可以重定向到主页
            return "redirect:/main.html";
        }
        //登录失败
        map.put("msg","用户名密码错误");
        return "login";
    }
}
