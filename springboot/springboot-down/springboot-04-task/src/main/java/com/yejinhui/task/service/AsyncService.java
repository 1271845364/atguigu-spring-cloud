package com.yejinhui.task.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author ye.jinhui
 * @project springboot-04-task
 * @description
 * @create 2018/10/18 10:18
 */
@Service
public class AsyncService {

    @Async  //告诉spring这是一个异步方法，spring会自动开启一个线程池进行调用
    public void hello() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("数据处理中...");
    }

}
