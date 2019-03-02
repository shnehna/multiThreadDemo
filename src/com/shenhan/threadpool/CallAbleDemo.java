package com.shenhan.threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author shenhan
 * @Date: 2019/3/2 17:27
 * @Description:
 */
public class CallAbleDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<String> submit = executorService.submit(new ThreadCallable());
        System.out.println(submit.get());
        Future<String> submit1 = executorService.submit(new ThreadCallable());
        System.out.println(submit1.get());
    }
    //手动创建线程池效果会更好
}
