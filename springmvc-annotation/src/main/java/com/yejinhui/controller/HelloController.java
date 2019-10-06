package com.yejinhui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yejinhui.service.HelloService;

/**
 * 
 * 
 * @author ye.jinhui
 * @date 2018年8月29日
 */
@Controller
public class HelloController {
	
	@Autowired
	private HelloService helloService;

	@ResponseBody
	@RequestMapping("/hello")
	public String hello() {
		return helloService.sayHello("tomcat ...");
	}
	
	@RequestMapping("/suc")
	public String success() {
		return "success";
	}
}
