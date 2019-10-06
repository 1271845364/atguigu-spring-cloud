package com.yejinhui;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yejinhui.bean.Person;
import com.yejinhui.config.MainConfig;

/**
 * @author ye.jinhui
 * @date 2018年8月18日
 */
public class MainTest {

	public static void main(String[] args) {
//		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
//		Person person = (Person) applicationContext.getBean("person");
//		System.out.println(person);
		
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
		Person person = (Person) applicationContext.getBean(Person.class);
		System.out.println(person);
		
		String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
		for (String name : beanNamesForType) {
			System.out.println(name);
		}
	}
}
