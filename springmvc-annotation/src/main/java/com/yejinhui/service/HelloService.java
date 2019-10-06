package com.yejinhui.service;

import org.springframework.stereotype.Service;

/**
 * 
 * @author ye.jinhui
 * @date 2018年8月29日
 */
@Service
public class HelloService {

	public String sayHello(String name) {
		return "Hello " + name;
	}
}
