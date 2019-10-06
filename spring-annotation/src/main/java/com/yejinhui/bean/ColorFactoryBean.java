package com.yejinhui.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * 创建Spring定义个工厂bean
 * 
 * @author ye.jinhui
 * @date 2018年8月18日
 */
public class ColorFactoryBean implements FactoryBean<Color> {

	/**
	 * 返回的这个对象会添加到容器中
	 */
	public Color getObject() throws Exception {
		System.out.println("ColorFactoryBean...");
		return new Color();
	}

	public Class<?> getObjectType() {
		return Color.class;
	}

	/**
	 * 是单例么
	 */
	public boolean isSingleton() {
		return false;
	}

}
