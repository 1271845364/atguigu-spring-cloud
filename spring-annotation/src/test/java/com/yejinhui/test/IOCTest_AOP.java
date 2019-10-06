package com.yejinhui.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yejinhui.aop.MathCalculator;
import com.yejinhui.config.MainConfigOfAOP;

/**
 * 
 * @author ye.jinhui
 * @date 2018年8月21日
 */
public class IOCTest_AOP {

	@Test
	public void test01() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				MainConfigOfAOP.class);
		
		//1.不要自己创建对象
//		MathCalculator calculator = new MathCalculator();
//		calculator.div(1, 1);
		MathCalculator calculator = applicationContext.getBean(MathCalculator.class);
		calculator.div(1, 0);
		
		applicationContext.close();
	}
}
