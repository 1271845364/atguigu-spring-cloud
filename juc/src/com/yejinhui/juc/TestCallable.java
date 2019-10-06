package com.yejinhui.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 一、创建执行线程的方式三：实现Callable接口。相较于实现Runnable接口的方式，方法可以有返回值，并且可以抛出异常。
 * 二、执行Callable方式，需要FutureTask实现类的支持，用于接收运算结果。FutureTask是Future接口的实现类
 * @author ye.jinhui
 * @create 2017-02-25 21:24
 */
public class TestCallable {

    public static void main(String[] args) {
        ThreadDemo2 td = new ThreadDemo2();

        //1.执行Callable方式，需要FutureTask实现类的支持，用于接收运算结果。
        FutureTask<Integer> result = new FutureTask<Integer>(td);
        new Thread(result).start();

        //2.接收线程运算后的结果
        try {
            int sum = result.get(); //FutureTask可用于 闭锁
            System.out.println(sum);
            System.out.println("--------------------------------------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
class ThreadDemo2 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for(int i=0;i<=100000;i++) {
            sum += i;
        }
        return sum;
    }
}
/*
class ThreadDemo implements Runnable {
    @Override
    public void run() {

    }
}*/
