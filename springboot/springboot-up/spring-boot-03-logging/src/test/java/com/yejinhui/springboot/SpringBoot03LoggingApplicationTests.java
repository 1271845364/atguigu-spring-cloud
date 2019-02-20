package com.yejinhui.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot03LoggingApplicationTests {

	//记录器
	Logger logger = LoggerFactory.getLogger(getClass());

	@Test
	public void contextLoads() {
//		System.out.println();
		//日志，面向slf4j接口编程
		//日志级别，由低到高trace < debug < info < warn < error
		//可以调整日志输出的级别，这个就是即便写了logg.info()这个便于调试，但是生产直接调整日志打印的级别，
		// 比如生产日志级别改成warn，那么生产只会打印warn、error
		logger.trace("这是trace日志...");
		logger.debug("这是debug日志...");
		//运行发现，SpringBoot默认给我们使用的是info级别的，没有指定级别的就用SpringBoot默认规定的级别：root级别
		logger.info("这是info日志...");
		logger.warn("这是warn日志...");
		logger.error("这是error日志...");


	}

}
