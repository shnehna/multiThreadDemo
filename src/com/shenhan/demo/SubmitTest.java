package com.shenhan.demo;

import java.util.concurrent.*;

/**
 * <类的简要说明>
 *
 * @author {Administrator}
 * @date {2019/3/4}
 */
public class SubmitTest {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20
                , 60L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(1024), new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 30; i++) {
            threadPoolExecutor.submit(new ThreadRunnablePool());
        }
    }

}

