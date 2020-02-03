package com.yejinhui.java1;

/**
 * @author ye.jinhui
 * @description
 * @program JVMDemo
 * @create 2020/1/31 18:10
 */
public class StringTest {

    public static void main(String[] args) {
        java.lang.String str = new java.lang.String();
        System.out.println("hello,yejinhui.com");


        //自定义类的加载器就是系统类加载器
        StringTest test = new StringTest();
        System.out.println(test.getClass().getClassLoader());//sun.misc.Launcher$AppClassLoader@14dad5dc
    }
}
