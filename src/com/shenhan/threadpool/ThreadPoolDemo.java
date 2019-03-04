package com.shenhan.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author shenhan
 * @Date: 2019/3/2 17:10
 * @Description: 线程池 使用Executor中的静态方法
 */
public class ThreadPoolDemo{
    public static void main(String[] args) {
        /*ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new ThreadPoolRunnable());
        executorService.submit(new ThreadPoolRunnable());
        executorService.submit(new ThreadPoolRunnable());*/

    }
    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20
            , 60L, TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<>(1024), new ThreadPoolExecutor.AbortPolicy());

}
