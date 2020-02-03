package com.yejinhui.java1;

/**
 * @author ye.jinhui
 * @description
 * @program JVMDemo
 * @create 2020/2/2 10:28
 */
public class DynamicLinkingTest {

    int num = 10;

    public void methodA() {
        System.out.println("methodA()...");
    }

    public void methodB() {
        System.out.println("methodB()...");

        methodA();
        num++;
    }
}
