package com.yejinhui.springboot;

import java.util.concurrent.TimeUnit;

/**
 * 分布式线程锁
 *
 * @author ye.jinhui
 * @project spring-boot-02-config
 * @description
 * @create 2018/11/28 9:58
 */
public class ThreadLock {

    /**
     * 获取锁
     *
     * @param acquireTimeOut 锁超时时长
     * @param timeUnit       时间单位
     * @return
     */
    public boolean lock(long acquireTimeOut, TimeUnit timeUnit) {
        acquireTimeOut = timeUnit.toMillis(acquireTimeOut);
        long acquireTime = acquireTimeOut + System.currentTimeMillis();
        //使用JUC的ReentrantLock

    }

}
