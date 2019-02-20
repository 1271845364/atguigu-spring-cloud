package com.yejinhui.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1、引入SpringSecurity
 * 2、编写SpringSecurity配置类
 *      @EnableWebSecurity
 *      public class MySecurityConfig extends WebSecurityConfigurerAdapter
 * 3、控制请求的访问权限
 *
 * @author ye.jinhui
 * @project springboot-05-security
 * @description
 * @create 2018/10/18 15:35
 */
@SpringBootApplication
public class Springboot05SecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot05SecurityApplication.class, args);
    }
}
