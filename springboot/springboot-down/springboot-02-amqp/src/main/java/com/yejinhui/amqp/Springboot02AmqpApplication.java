package com.yejinhui.amqp;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 自动配置
 * 1、RabbitAutoConfiguration
 * 2、有自动配置了链接工厂 CachingConnectionFactory
 * 3、RabbitProperties 封装了 RabbitMQ 的配置
 * 4、RabbitTemplate ：RabbitMQ 发送和接收消息
 * 5、AmqpAdmin ：RabbitMQ 系统管理功能组件
 * AmqpAdmin：创建和删除 Queue，Exchange，Binding
 * 6、@EnableRabbit + @RabbitListener 监听消息队列的内容
 *
 * @author ye.jinhui
 * @project springboot-02-amqp
 * @description
 * @create 2018/10/16 16:42
 */
@EnableRabbit   //开启基于注解的 RabbitMQ 模式
@SpringBootApplication
public class Springboot02AmqpApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot02AmqpApplication.class);
    }

}
