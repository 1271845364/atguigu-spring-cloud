package com.yejinhui.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.yejinhui.controller.MyFirstInterceptor;

/**
 * @author ye.jinhui
 * @date 2018年8月29日
 */
// SpringMVC只扫描Controller；子容器
// useDefaultFilters = false 禁用过滤的默认规则
@ComponentScan(value = "com.yejinhui", includeFilters = {
		@Filter(type = FilterType.ANNOTATION, classes = { Controller.class }) }, useDefaultFilters = false)
@EnableWebMvc
public class AppConfig extends WebMvcConfigurerAdapter {

	// 定制视图解析器
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// 默认所有的页面都从/WEB-INF/xxx.jsp
		// registry.jsp();
		registry.jsp("/WEB-INF/views/", ".jsp");
	}

	// 开启静态资源访问
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	// 拦截器
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new MyFirstInterceptor()).addPathPatterns("/**");
	}

}
