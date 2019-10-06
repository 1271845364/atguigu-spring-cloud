package com.yejinhui.test;

import java.util.Map;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import com.yejinhui.bean.Blue;
import com.yejinhui.bean.Person;
import com.yejinhui.config.MainConfig;
import com.yejinhui.config.MainConfig2;

/**
 * 
 * @author ye.jinhui
 * @date 2018年8月18日
 */
public class IOCTest {
	
	AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
	
	@Test
	public void testImport() {
		print(applicationContext);
		Blue blue = applicationContext.getBean(Blue.class);
		System.out.println(blue);
		
		//工厂bean的获取是调用的getObject创建的对象
		Object bean = applicationContext.getBean("colorFactoryBean");
		Object bean2 = applicationContext.getBean("colorFactoryBean");
		System.out.println("bean的类型：" + bean.getClass());
		System.out.println(bean == bean2);
		
		Object bean3 = applicationContext.getBean("&colorFactoryBean");
		System.out.println(bean3.getClass());
	}
	
	private void print(AnnotationConfigApplicationContext applicationContext) {
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String name : beanDefinitionNames) {
			System.out.println(name);
		}
	}
	
	@Test
	public void test03() {
		String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
		
		ConfigurableEnvironment configurableEnvironment = applicationContext.getEnvironment();
		//动态获取环境变量的值；Windows 10
		String property = configurableEnvironment.getProperty("os.name");
		System.out.println(property);
		
		for (String name : beanNamesForType) {
			System.out.println(name);
		}
		
		Map<String, Person> persons = applicationContext.getBeansOfType(Person.class);
		System.out.println(persons);
	}
	
	@Test
	public void test02() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
//		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
//		for (String name : beanDefinitionNames) {
//			System.out.println(name);
//		}
		System.out.println("ioc容器创建完成");
		Object bean = applicationContext.getBean("person");
		Object bean2 = applicationContext.getBean("person");
		System.out.println(bean == bean2);
	}
	
	@Test
	public void test01() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String name : beanDefinitionNames) {
			System.out.println(name);
		}
	}
}
