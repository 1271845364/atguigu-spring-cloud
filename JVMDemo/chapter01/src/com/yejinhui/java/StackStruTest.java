package com.yejinhui.java;

/**
 * @author ye.jinhui
 * @description
 * @program JVMDemo
 * @create 2020/1/30 11:15
 */
public class StackStruTest {

    public static void main(String[] args) {
//        int i = 2+3;
        int i = 2;
        int j=3;
        int k = i+j;

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("hello");
    }
}
