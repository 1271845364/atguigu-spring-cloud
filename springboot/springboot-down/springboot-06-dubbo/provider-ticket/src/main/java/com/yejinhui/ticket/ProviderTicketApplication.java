package com.yejinhui.ticket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1、将服务提供者注册到注册中心
 *      a、引入dubbo和zkclient的相关依赖
 *      b、配置dubbo的扫描包和注册中心地址
 *      c、使用 @Service 发布服务
 *
 *
 * @author ye.jinhui
 * @project springboot-06-dubbo
 * @description
 * @create 2018/11/6 11:08
 */
@SpringBootApplication
public class ProviderTicketApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderTicketApplication.class, args);
    }
}
