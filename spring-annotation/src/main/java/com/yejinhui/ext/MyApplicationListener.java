package com.yejinhui.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 
 * @author ye.jinhui
 * @date 2018年8月27日
 */
@Component
public class MyApplicationListener implements ApplicationListener<ApplicationEvent> {

	// 当容器中发布此事件以后，方法触发
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("收到事件：" + event);
	}

}
