package com.yejinhui.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 
 * @author ye.jinhui
 * @date 2018年11月21日
 */
@SpringBootApplication
@EnableConfigServer
public class Config_3344_StartSpringCloudApp {
	public static void main(String[] args) {
		SpringApplication.run(Config_3344_StartSpringCloudApp.class, args);
	}
}