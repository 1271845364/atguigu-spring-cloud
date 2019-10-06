package com.yejinhui.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 判断操作系统是否为Linux
 * 
 * @author ye.jinhui
 * @date 2018年8月18日
 */
public class LinuxCondition implements Condition {

	/**
	 * @param context
	 *            判断条件能使用的上下文(环境)
	 * @param metadata
	 *            注解的注释信息
	 */
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		// 1.获取ioc使用的bean factory
		ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
		// 2.获取类加载器
		ClassLoader classLoader = context.getClassLoader();
		// 3.获取当前环境
		Environment environment = context.getEnvironment();
		// 4.获取到bean定义的注册类
		BeanDefinitionRegistry registry = context.getRegistry();

		String property = environment.getProperty("os.name");
		
		//可以判断容器中的bean注册情况，也可以给容器中注册bean
		boolean definition = registry.containsBeanDefinition("person");
		if (property.contains("linux")) {
			return true;
		}
		return false;
	}

}
