package com.yejinhui.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import java.util.concurrent.TimeUnit;

/**
 * @author ye.jinhui
 * @version v1.0.0
 * @date 2018/9/7 16:30
 */
//@ImportResource(value = {"classpath:beans.xml"})
//@SpringBootApplication
public class SpringBoot02ConfigApplication {

    public static void main(String[] args) {
//        SpringApplication.run(SpringBoot02ConfigApplication.class, args);
        System.out.println(lock(100,TimeUnit.MILLISECONDS));
    }



}

