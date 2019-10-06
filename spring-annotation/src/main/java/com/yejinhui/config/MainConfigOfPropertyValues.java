package com.yejinhui.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import com.yejinhui.bean.Person;

/**
 * 
 * 
 * @author ye.jinhui
 * @date 2018年8月20日
 */
@Configuration
//使用@PropertySource读取外部配置文件中的k/v保存到运行的环境变量中；加载完外部的配置文件以后使用${}取出配置文件的值
//@PropertySource(value = "classpath:/person.properties")
@PropertySources(value={
		@PropertySource(value = {"classpath:/person.properties"})	
})
public class MainConfigOfPropertyValues {

	@Bean
	public Person person() {
		return new Person();
	}
}
