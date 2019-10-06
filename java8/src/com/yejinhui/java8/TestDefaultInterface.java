package com.yejinhui.java8;

/**
 * 
 * @author ye.jinhui
 * @date 2018年8月13日
 */
public class TestDefaultInterface {

	public static void main(String[] args) {
		SubClass subClass = new SubClass();
		String name = subClass.getName();
		System.out.println(name);
		
		MyInterface.show();
	}
}
