package com.yejinhui.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 一、i++的原子性问题：i++的操作实际分为三个步骤“读-改-写”
 *          int i=10;
 *          i=i++;
 *
 *          int temp=i;
 *          i=i+1;
 *          i=temp;
 *
 * 二、原子变量：jdk1.5后java.util.concurrent.atomic包下提供了常用的原子变量：
 *      1.volatile保证内存可见性
 *      2.CAS(Compare-And-Swap)算法保证数据的原子性
 *          CAS算法是硬件对于并发操作共享数据的支持
 *          CAS包含了三个操作数：
 *          内存值V
 *          预估值A
 *          更新值B
 *          当且仅当V == A时，V=B。否则，将不做任何操作
 *
 * @author ye.jinhui
 * @create 2017-02-24 23:11
 */
public class TestAtomicDemo {

    public static void main(String[] args) {
        AtomicDemo ad = new AtomicDemo();

        for(int i=0;i<10;i++) {
            new Thread(ad).start();
        }
    }
}

class AtomicDemo implements Runnable {

//    private volatile int serialNumber = 0;

    private AtomicInteger serialNumber = new AtomicInteger(0);

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ":" + getSerialNumber());
    }

    public int getSerialNumber() {
        return serialNumber.getAndIncrement();
        //int temp = i;
        //i=i+1;
    }
}