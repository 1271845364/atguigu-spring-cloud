package com.yejinhui.test;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yejinhui.bean.Yellow;
import com.yejinhui.config.MainConfigOfProfile;

/**
 * 
 * @author ye.jinhui
 * @date 2018年8月21日
 */
public class IOCTest_Profile {

	// 1、使用命令行动态参数：在虚拟机参数位置加载-Dspring.profiles.active=test
	// 2、代码的方式激活环境
	@Test
	public void test01() {
		//1.创建一个ioc容器
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

		//2.设置需要激活的环境
		applicationContext.getEnvironment().setActiveProfiles("dev");
		
		//3.注册主配置类
		applicationContext.register(MainConfigOfProfile.class);
		
		//4.刷新
		applicationContext.refresh();
		
		String[] beanNamesForType = applicationContext.getBeanNamesForType(DataSource.class);
		for (String beanName : beanNamesForType) {
			System.out.println(beanName);
		}

		Yellow yellow = applicationContext.getBean(Yellow.class);
		System.out.println(yellow);
		
		applicationContext.close();
	}
}
