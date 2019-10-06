package com.yejinhui.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *编写一个程序，开启3 个线程，这三个线程的ID 分别为
 A、B、C，每个线程将自己的ID 在屏幕上打印10 遍，要
 求输出的结果必须按顺序显示。
 如：ABCABCABC…… 依次递归
 * @author ye.jinhui
 * @create 2017-02-26 11:31
 */
public class TestABCAlternate {

    public static void main(String[] args) {
        Business business = new Business();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++) {
                    business.sub1();
                }
            }
        },"A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++) {
                    business.sub2();
                }
            }
        },"B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++) {
                    business.sub3();
                }
            }
        },"C").start();
    }

}

class Business {
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    private int subShould = 1;

    public void sub1() {
        lock.lock();
        try {
            while (subShould != 1) {
                try {
                    condition1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print(Thread.currentThread().getName());
            subShould = 2;
            condition2.signal();
        }finally {
            lock.unlock();
        }
    }

    public void sub2() {
        lock.lock();
        try {
            while (subShould != 2) {
                try {
                    condition2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print(Thread.currentThread().getName());
            subShould = 3;
            condition3.signal();
        }finally {
            lock.unlock();
        }
    }

    public void sub3() {
        lock.lock();
        try {
            while (subShould != 3) {
                try {
                    condition3.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print(Thread.currentThread().getName());
            subShould = 1;
            condition1.signal();
        }finally {
            lock.unlock();
        }
    }

}