package com.yejinhui.java;

/**
 * @author ye.jinhui
 * @description
 * @program JVMDemo
 * @create 2020/2/3 18:21
 */
public class IHaveNatives {

    public native/* abstract */void Native1(int x);

    native static public long Native2();

    native synchronized private float Native3(Object o);

    native void Native4(int[] ary) throws Exception;
}
