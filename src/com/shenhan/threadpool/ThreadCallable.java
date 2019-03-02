package com.shenhan.threadpool;

import java.util.concurrent.Callable;

/**
 * @Author shenhan
 * @Date: 2019/3/2 17:29
 * @Description:
 */
public class ThreadCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "abc" + Thread.currentThread().getName();
    }
}
