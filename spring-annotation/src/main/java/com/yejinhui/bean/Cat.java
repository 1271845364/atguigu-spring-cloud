package com.yejinhui.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * 
 * @author ye.jinhui
 * @date 2018年8月20日
 */
@Component
public class Cat implements InitializingBean, DisposableBean {

	public Cat() {
		System.out.println("cat constructor ...");
	}

	public void destroy() throws Exception {
		System.out.println("cat...destroy...");
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("cat...afterPropertiesSet...");
	}
}
