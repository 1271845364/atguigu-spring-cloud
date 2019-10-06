package com.yejinhui.java8;

/**
 * 
 * @author ye.jinhui
 * @date 2018年8月13日
 */
public class SubClass/* extends MyClass */implements MyFun,MyInterface{

	@Override
	public Integer getValue(Integer num) {
		return null;
	}

	@Override
	public String getName() {
		return MyFun.super.getName();
	}

}
