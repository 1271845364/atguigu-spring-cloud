package com.yejinhui.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class Dog implements ApplicationContextAware{

	private ApplicationContext applcationContext;

	public Dog(){
		System.out.println("dog constructor...");
	}
	
	//在对象创建并赋值之后调用
	@PostConstruct
	public void init() {
		System.out.println("dog ... @PostConstruct...");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("dog ... @PreDestroy ...");
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applcationContext = applicationContext;
	}
}
