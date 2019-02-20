package com.yejinhui.myrule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;

/**
 * 
 * @author ye.jinhui
 * @date 2018年11月16日
 */
@Configuration
public class MySelfRule {

	@Bean
	public IRule myRule() {
//		return new RandomRule();//Ribbon默认是轮询，我自定义为随机
		return new RandomRule_YJH();	//每台机器5次
	}

}
