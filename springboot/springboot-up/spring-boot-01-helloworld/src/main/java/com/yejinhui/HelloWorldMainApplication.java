package com.yejinhui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @SpringBootApplication 来标注一个主程序，说明这个一个Spring Boot应用
 *
 * @author ye.jinhui
 * @version v1.0.0
 * @date 2018/9/4 17:01
 */
@SpringBootApplication
public class HelloWorldMainApplication {

    public static void main(String[] args) {
        //Spring Boot应用启动
        SpringApplication.run(HelloWorldMainApplication.class,args);
    }
}
