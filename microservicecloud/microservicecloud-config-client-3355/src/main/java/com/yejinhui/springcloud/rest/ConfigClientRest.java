package com.yejinhui.springcloud.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author ye.jinhui
 * @date 2018年11月21日
 */
@RestController
public class ConfigClientRest {
	
	//读自己配置文件中的信息
	@Value("${spring.application.name}")
	private String applicationName;

	@Value("${eureka.client.service-url.defaultZone}")
	private String eurekaServers;

	@Value("${server.port}")
	private String port;

	@RequestMapping("/config")
	public String getConfig() {
		String str = "applicationName:" + applicationName + "\t eurekaServers：" + eurekaServers + "\t port:" + port;
		System.out.println("*******str:" + str);
		return str;
	}
}
