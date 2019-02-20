package com.yejinhui.springboot08actuator.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * @author ye.jinhui
 * @project springboot-08-actuator
 * @description
 * @create 2018/11/9 17:38
 */
@Component
public class MyAppHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {

        //自定义检查方法
//        Health.up().build(); 代表健康
        return Health.down().withDetail("msg","服务异常").build();
    }
}
