package com.yejinhui;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.yejinhui.config.AppConfig;
import com.yejinhui.config.RootConfig;

/**
 * 
 * web容器在启动的时候创建对象，调用此方法来初始化容器和前端控制器
 * 
 * @author ye.jinhui
 * @date 2018年8月29日
 */
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	/**
	 * 获取根容器的配置类：（Spring的配置文件）创建一个父容器
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { RootConfig.class };
	}

	/**
	 * 获取web容器的配置类：（SpringMVC的配置文件） 创建一个子容器
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { AppConfig.class };
	}

	/**
	 * 获取DispatchServlet的映射信息 /:拦截所有请求（包括：静态资源【xx.js，xx.png】），但是不包括*.jsp
	 * /*:拦截所有请求，连*.jsp页面也拦截；jsp页面是tomcat引擎解析的
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
