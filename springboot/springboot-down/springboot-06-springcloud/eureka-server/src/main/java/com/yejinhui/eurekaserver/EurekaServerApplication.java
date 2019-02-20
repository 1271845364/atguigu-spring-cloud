package com.yejinhui.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 注册中心
 * 1、配置Eureka信息
 * 2、@EnableEurekaServer 启用Eureka注册中心功能
 *
 * @author ye.jinhui
 * @project springboot-06-springcloud
 * @description
 * @create 2018/11/7 19:06
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }

}
