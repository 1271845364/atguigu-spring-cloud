package com.yejinhui.java8;

@FunctionalInterface
public interface MyFun {

	Integer getValue(Integer num);

	default String getName(){
		return "哈哈哈";
	}
}
