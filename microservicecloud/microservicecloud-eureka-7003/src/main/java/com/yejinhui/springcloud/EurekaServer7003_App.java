package com.yejinhui.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 
 * @author ye.jinhui
 * @date 2018年11月14日
 */
@SpringBootApplication
@EnableEurekaServer // EurekaServer服务器端启动类,接受其它微服务注册进来
public class EurekaServer7003_App {
	public static void main(String[] args) {
		SpringApplication.run(EurekaServer7003_App.class, args);
	}
}
