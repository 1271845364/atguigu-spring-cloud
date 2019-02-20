package com.yejinhui.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1、引入dubbo和zkclient依赖
 * 2、配置dubbo的注册中心地址
 * 3、消费dubbo服务
 *
 * @author ye.jinhui
 * @project springboot-06-dubbo
 * @description
 * @create 2018/11/6 11:08
 */
@SpringBootApplication
public class ConsumerUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerUserApplication.class, args);
    }
}
