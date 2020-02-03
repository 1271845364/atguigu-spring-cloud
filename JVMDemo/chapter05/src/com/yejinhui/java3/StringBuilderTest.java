package com.yejinhui.java3;

/**
 * 面试题：方法中定义的局部变量是否线程安全？具体情况具体分析
 *
 * 何为线程安全？
 *  1、如果只有一个线程才可以操作此数据，则必是线程安全的
 *  2、如果有多个线程操作此数据，则数据是共享的。如果不考虑同步机制的话，是存在线程安全问题的
 *
 * @author ye.jinhui
 * @description
 * @program JVMDemo
 * @create 2020/2/2 22:13
 */
public class StringBuilderTest {

    //s1的声明方式是线程安全的
    public static void method1() {
        //StringBuilder是线程不安全的
        StringBuilder s1 = new StringBuilder();
        s1.append("a");
        s1.append("b");
    }

    //stringBuilder的操作过程：是线程不安全的，多个线程都调用这个方法，传入同一个stringBuilder就不安全
    public static void method2(StringBuilder stringBuilder) throws InterruptedException {
        stringBuilder.append("a");
        stringBuilder.append("b");
    }

    //stringBuilder的操作过程：是线程不安全的，返回值了，多个线程都操作这个stringBuilder就不安全
    public static StringBuilder method3() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("a");
        stringBuilder.append("b");
        return stringBuilder;
    }

    //stringBuilder的操作过程：是线程安全的
    public static String method4() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("a");
        stringBuilder.append("b");
        return stringBuilder.toString();
    }

    public static void main(String[] args) throws InterruptedException {
        StringBuilder stringBuilder = new StringBuilder();

        new Thread(()->{
            stringBuilder.append("a");
            stringBuilder.append("b");
        }).start();

        method2(stringBuilder);
    }
}
