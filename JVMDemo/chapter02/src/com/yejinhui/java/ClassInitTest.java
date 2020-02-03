package com.yejinhui.java;

/**
 * @author ye.jinhui
 * @description
 * @program JVMDemo
 * @create 2020/1/30 21:46
 */
public class ClassInitTest {

    private static int num = 1;

    static {
        num = 2;
        number = 20;
        System.out.println(num);
//        System.out.println(number);//报错：非法的前项引用
    }

    //linking之prepare: number = 0 --> initial: 20-->10
    private static int number = 10;

    public static void main(String[] args) {
        System.out.println(ClassInitTest.num);
        System.out.println(ClassInitTest.number);
    }
}
