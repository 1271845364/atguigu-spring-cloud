package com.yejinhui.java;

/**
 * @author ye.jinhui
 * @description
 * @program JVMDemo
 * @create 2020/2/1 11:12
 */
public class StackTest {

    public static void main(String[] args) {
        StackTest stackTest = new StackTest();
        stackTest.methodA();
    }

    public void methodA() {
        int i = 10;
        int j = 20;

        methodB();
    }

    public void methodB() {
        int k = 30;
        int m = 40;
    }
}
