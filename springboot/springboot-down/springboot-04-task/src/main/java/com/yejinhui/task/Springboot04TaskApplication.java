package com.yejinhui.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author ye.jinhui
 * @project springboot-04-task
 * @description
 * @create 2018/10/18 10:17
 */
@EnableScheduling   //开启定时任务注解功能
@EnableAsync    //开启异步任务注解功能
@SpringBootApplication
public class Springboot04TaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot04TaskApplication.class, args);
    }
}
