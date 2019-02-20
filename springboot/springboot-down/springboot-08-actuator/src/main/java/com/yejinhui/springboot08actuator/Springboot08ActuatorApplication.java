package com.yejinhui.springboot08actuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 自定义健康状态指示器
 * 1、编写一个指示器 实现 HealthIndicator 接口
 * 2、指示器的名字xxxHealthIndicator
 * 3、加入容器中
 *
 * @author ye.jinhui
 * @project springboot-08-actuator
 * @description
 * @create 2018/11/9 16:03
 */
@SpringBootApplication
public class Springboot08ActuatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot08ActuatorApplication.class, args);
    }
}
