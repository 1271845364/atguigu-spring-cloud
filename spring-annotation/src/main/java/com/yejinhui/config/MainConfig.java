package com.yejinhui.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

import com.yejinhui.bean.Person;
import com.yejinhui.service.BookService;

/**
 * 配置类 = 配置文件
 * 
 * @author ye.jinhui
 * @date 2018年8月18日
 */
@Configuration // 告诉spring这是一个配置类
@ComponentScans(value={
		@ComponentScan(value = "com.yejinhui",includeFilters={
				/*@Filter(type=FilterType.ANNOTATION,classes={Controller.class}),
				@Filter(type=FilterType.ASSIGNABLE_TYPE,classes={BookService.class}),*/
				@Filter(type=FilterType.CUSTOM,classes={MyTypeFilter.class})
		},useDefaultFilters=false)	
})
//@ComponentScan  value：指定要扫描的包
//excludeFilters = Filter[]	:指定扫描的时候按照什么规则排除那些组件
//includeFilters = Filter[] :指定扫描的时候只需要包含那些组件
//FilterType.ANNOTATION:按照注解
//FilterType.ASSIGNABLE_TYPE:按照给定的类型
//FilterType.ASPECTJ:ASPECTJ表达式不太常用
//FilterType.REGEX:使用正则指定
//FilterType.CUSTOM:使用自定义规则
public class MainConfig {

	// 给容器中注册一个bean；类型作为返回值类型，id默认是用方法名作为id
	@Bean("person")
	public Person person01() {
		return new Person("lisi", 20);
	}

}
