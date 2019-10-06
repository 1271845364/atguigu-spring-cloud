package com.yejinhui.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import com.yejinhui.bean.Person;
import com.yejinhui.config.MainConfigOfPropertyValues;

/**
 * 
 * @author ye.jinhui
 * @date 2018年8月20日
 */
public class IOCTest_PropertyValue {

	AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
			MainConfigOfPropertyValues.class);

	@Test
	public void test01() {
		printBeans(applicationContext);
		System.out.println("=======================");
		Person person = (Person) applicationContext.getBean("person");
		System.out.println(person);
		
		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		System.out.println(environment.getProperty("person.nickName"));
		
		applicationContext.close();
	}

	private void printBeans(AnnotationConfigApplicationContext applicationContext) {
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String name : beanDefinitionNames) {
			System.out.println(name);
		}
	}
}
