package com.yejinhui.springboot;

import com.yejinhui.springboot.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * SpringBoot单元测试;
 *
 * 可以在测试期间很方便的类似编码一样进行自动注入等容器的功能
 * @author ye.jinhui
 * @version v1.0.0
 * @date 2018/9/7 16:30
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot02ConfigApplicationTests {

	@Autowired
	private Person person;

	@Autowired
	private ApplicationContext ioc;

	@Test
	public void testHelloService() {
		boolean b = ioc.containsBean("helloService02");
		System.out.println(b);
	}

	@Test
	public void contextLoads() {
		System.out.println(person);
	}

}
