package com.yejinhui.java1;

/**
 * @author ye.jinhui
 * @description
 * @program JVMDemo
 * @create 2020/1/31 17:57
 */
public class ClassLoaderTest2 {

    public static void main(String[] args) {
        try {
            //1.
            ClassLoader classLoader = Class.forName("java.lang.String").getClassLoader();
            System.out.println(classLoader);//null

            //2.
            ClassLoader classLoader1 = Thread.currentThread().getContextClassLoader();
            System.out.println(classLoader1);//sun.misc.Launcher$AppClassLoader@14dad5dc

            //3.
            ClassLoader classLoader2 = ClassLoader.getSystemClassLoader().getParent();
            System.out.println(classLoader2);//sun.misc.Launcher$ExtClassLoader@1b6d3586

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
