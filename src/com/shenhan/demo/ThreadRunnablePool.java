package com.shenhan.demo;

/**
 * <类的简要说明>
 *
 * @author {Administrator}
 * @date {2019/3/4}
 */
public class ThreadRunnablePool implements Runnable {
    @Override
    public void run() {
        System.out.println("线程"+Thread.currentThread().getName()+"开始运行");
        int i=10000*10000;
        while(i>0)
        {
            i--;
        }
        System.out.println("线程"+Thread.currentThread().getName()+"运行结束");
    }
}
