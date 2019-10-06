package com.yejinhui.bean;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author ye.jinhui
 * @date 2018年8月18日
 */
public class Person {

	/**
	 * 使用@Value赋值 1.基本数值 2.可以写SpEL；#{}
	 * 3.可以写${}，取出配置文件中的值(在运行环境变量中的值)，程序在运行中读的配置文件中的值都会放到环境变量中
	 */
	@Value("张三")
	private String name;
	@Value("#{20-2}")
	private Integer age;
	
	@Value("${person.nickName}")
	private String nickName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Person() {
		super();
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", nickName=" + nickName + "]";
	}

}
