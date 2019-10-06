package com.yejinhui.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yejinhui.bean.Car;
import com.yejinhui.config.MainConfigOfLifeCycle;

/**
 * 
 * @author ye.jinhui
 * @date 2018年8月20日
 */
public class IOCTest_LifeCycle {

	@Test
	public void test01() {
		//1.创建ioc容器
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
		System.out.println("容器创建完成");
		
//		Car car = (Car) applicationContext.getBean("car");
		applicationContext.close();
	}
}
