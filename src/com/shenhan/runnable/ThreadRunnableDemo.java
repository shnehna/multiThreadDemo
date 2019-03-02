package com.shenhan.runnable;


/**
 * @Author shenhan
 * @Date: 2019/3/2 16:18
 * @Description:实现接口线程
 */
public class ThreadRunnableDemo {
    public static void main(String[] args) {
        SubRunnable sub = new SubRunnable();
        Thread t = new Thread(sub);
        t.start();
        for (int j = 0; j < 500; j++) {
            System.out.println("mian..." + j);
        }
    }
}
