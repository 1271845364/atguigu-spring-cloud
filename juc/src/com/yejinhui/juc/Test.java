package com.yejinhui.juc;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CountDownLatch;

/**
 * @author ye.jinhui
 * @project juc
 * @description
 * @create 2018/10/28 17:33
 */
public class Test {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(5);

        Latch latch = new Latch(countDownLatch);

        Instant start = Instant.now();
        for (int i = 0; i < 5; i++) {
            new Thread(latch).start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant end = Instant.now();
        System.out.println(Duration.between(start,end).toMillis() + "ms");
    }

}

class Latch implements Runnable {

    private CountDownLatch latch;

    public Latch(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        synchronized (this) {
            try {
                for(int i=0;i<5000;i++) {
                    if(i%2==0) {
                        System.out.println("i = " + i);
                    }
                }
            }finally {
                latch.countDown();
            }
        }
    }
}