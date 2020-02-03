package com.yejinhui.java1;

/**
 *
 * 方法结束的方式分为两种：1、正常结束，return 2、方法执行过程中出现异常没有捕获，以异常方式结束
 *
 * @author ye.jinhui
 * @description
 * @program JVMDemo
 * @create 2020/2/1 13:38
 */
public class StackFrameTest {

    public static void main(String[] args) {
        StackFrameTest stackFrameTest = new StackFrameTest();
        stackFrameTest.method1();
    }

    public void method1() {
        System.out.println("method1()开始执行...");
        method2();
        System.out.println("method1()执行结束...");
    }

    public int method2() {
        System.out.println("method2()开始执行...");
        int i = 10;
        int m = (int) method3();
        System.out.println("method2()即将结束...");
        return i;
    }

    public double method3() {
        System.out.println("method3()开始执行...");
        double j = 20.0;
        System.out.println("method3()即将结束...");
        return j;
    }


}
