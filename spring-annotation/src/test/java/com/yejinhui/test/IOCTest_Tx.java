package com.yejinhui.test;

import java.io.FileNotFoundException;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yejinhui.tx.TxConfig;
import com.yejinhui.tx.UserService;

/**
 * 
 * @author ye.jinhui
 * @date 2018年8月24日
 */
public class IOCTest_Tx {

	@Test
	public void test01() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TxConfig.class);

		UserService userService = applicationContext.getBean(UserService.class);
		try {
			userService.insertUser();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		applicationContext.close();
	}
	
}
