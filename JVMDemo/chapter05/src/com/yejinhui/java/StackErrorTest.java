package com.yejinhui.java;

/**
 * 演示栈中的异常
 *
 * @author ye.jinhui
 * @description
 * @program JVMDemo
 * @create 2020/2/1 12:25
 *
 * 默认情况下：count = 9503
 * 设置栈大小：-Xss256k ccount = 2067
 *
 *
 */
public class StackErrorTest {

    private static int count = 1;

    public static void main(String[] args) {
        //Exception in thread "main" java.lang.StackOverflowError
        //不断的压栈，导致栈溢出
        System.out.println(count++);
        main(args);
    }
}
