package com.yejinhui.consumeruser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author ye.jinhui
 * @project springboot-06-springcloud
 * @description
 * @create 2018/11/7 19:06
 */
@EnableDiscoveryClient  //开启发现服务功能
@SpringBootApplication
public class ConsumerUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerUserApplication.class, args);
    }

    //用于调取eureka中的其他服务，用来发送http请求
    @LoadBalanced   //在发送http请求的时候开启负载均衡机制
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
