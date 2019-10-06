package com.yejinhui.test;

import org.junit.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yejinhui.ext.ExtConfig;

/**
 * 
 * @author ye.jinhui
 * @date 2018年8月24日
 */
public class IOCTest_Ext {

	@Test
	public void test01() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				ExtConfig.class);
		
		//发布自定义事件
		applicationContext.publishEvent(new ApplicationEvent(new String("我发布的事件")) {
			
		});
		
		applicationContext.close();
	}
}
