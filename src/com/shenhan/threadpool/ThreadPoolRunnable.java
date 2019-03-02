package com.shenhan.threadpool;

/**
 * @Author shenhan
 * @Date: 2019/3/2 17:16
 * @Description:
 */
public class ThreadPoolRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程提交的任务");
    }
}
