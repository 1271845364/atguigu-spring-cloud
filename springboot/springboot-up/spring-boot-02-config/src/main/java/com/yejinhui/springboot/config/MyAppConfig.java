package com.yejinhui.springboot.config;

import com.yejinhui.springboot.bean.Person;
import com.yejinhui.springboot.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration  指明当前类为配置类，就是用来替代之前的Spring配置文件
 *
 * 在配置文件中用<bean></bean>标签添加组件
 *
 * @author ye.jinhui
 * @version v1.0.0
 * @date 2018/9/15 16:30
 */
@Configuration
public class MyAppConfig {

    /**
     * 将方法的返回值添加到容器中；容器中这个组件默认的id就是方法名
     *
     * @return
     */
    @Bean
    public HelloService helloService02() {
        System.out.println("配置类@Bean给容器中添加组件了...");
        return new HelloService();
    }

    @Bean
    public Person person() {
        return new Person();
    }

}
