package com.shenhan.threadpool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.shenhan.SubThread;

import java.util.concurrent.*;

/**
 * <类的简要说明>
 *
 * @author {Administrator}
 * @date {2019/3/3}
 */
public class ThreadFactoryBuilderDemo {
    private static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
            .setNameFormat("demo-pool-%d").build();

    private static ExecutorService pool = new ThreadPoolExecutor(5, 200,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            pool.execute(new SubThread());
        }
    }
}
