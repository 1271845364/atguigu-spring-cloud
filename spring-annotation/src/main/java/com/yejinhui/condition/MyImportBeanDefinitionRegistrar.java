package com.yejinhui.condition;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import com.yejinhui.bean.RainBow;

/**
 * 
 * @author ye.jinhui
 * @date 2018年8月18日
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	/**
	 * @param importingClassMetadata 当前类的注解信息
	 * @param registry BeanDefinition注册类
	 * 					把所有需要添加到容器中的bean；调用BeanDefinitionRegistry.registerBeanDefinition手工注册进来
	 */
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		boolean definition = registry.containsBeanDefinition("com.yejinhui.bean.Red");
		boolean definition2 = registry.containsBeanDefinition("com.yejinhui.bean.Blue");
		if(definition && definition2) {
			//指定Bean的定义信息，
			RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(RainBow.class);
			//注册一个bean，指定bean名
			registry.registerBeanDefinition("rainBow", rootBeanDefinition);
		}
	}

}
