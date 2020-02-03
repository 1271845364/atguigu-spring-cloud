package com.yejinhui.java;

/**
 * <clinit>()方法在多线程下被同步加锁
 *
 * @author ye.jinhui
 * @description
 * @program JVMDemo
 * @create 2020/1/30 22:41
 */
public class DeadThreadTest {

    public static void main(String[] args) {
        Runnable r = ()->{
            System.out.println(Thread.currentThread().getName()+"开始");
            DeadThread deadThread = new DeadThread();
            System.out.println(Thread.currentThread().getName()+"结束");
        };

        Thread t1 = new Thread(r,"线程1");
        Thread t2 = new Thread(r,"线程2");

        t1.start();
        t2.start();
    }
}
class DeadThread{
    static {
        if(true) {
            System.out.println(Thread.currentThread().getName()+"初始化当前类");
            while (true) {

            }
        }
    }
}