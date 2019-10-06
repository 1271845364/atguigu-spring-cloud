package com.yejinhui.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yejinhui.bean.Boss;
import com.yejinhui.bean.Car;
import com.yejinhui.bean.Color;
import com.yejinhui.config.MainConfigOfAutowired;
import com.yejinhui.dao.BookDao;
import com.yejinhui.service.BookService;

/**
 * 
 * @author ye.jinhui
 * @date 2018年8月20日
 */
public class IOCTest_Autowired {

	@Test
	public void test01() {
		// 1.创建ioc容器
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				MainConfigOfAutowired.class);
		BookService bookService = applicationContext.getBean(BookService.class);
		System.out.println(bookService);

		BookDao bookDao = applicationContext.getBean(BookDao.class);
		System.out.println(bookDao.toString());

		Boss boss = applicationContext.getBean(Boss.class);
		System.out.println(boss);

		Car car = applicationContext.getBean(Car.class);
		System.out.println(car);
		
		Color color = applicationContext.getBean(Color.class);
		System.out.println(color);
		
		System.out.println(applicationContext);
		applicationContext.close();
	}
}
