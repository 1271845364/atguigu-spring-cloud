package com.yejinhui.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * @author ye.jinhui
 * @date 2018年11月16日
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages= {"com.yejinhui.springcloud"})
@ComponentScan("com.yejinhui.springcloud")
public class DeptConsumer80_Feign_App {
	public static void main(String[] args) {
		SpringApplication.run(DeptConsumer80_Feign_App.class, args);
	}
}