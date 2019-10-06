package com.yejinhui.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @author ye.jinhui
 * @date 2018年8月29日
 */
//Spring容器不扫描Controller，controller交给SpringMVC扫描
@ComponentScan(value = "com.yejinhui", excludeFilters = {
		@Filter(type = FilterType.ANNOTATION, classes = { Controller.class }) })
public class RootConfig {

}
