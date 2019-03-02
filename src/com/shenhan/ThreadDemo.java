package com.shenhan;

/**
 * @Author shenhan
 * @Date: 2019/3/2 11:35
 * @Description: 创建和启动一个线程
 */
public class ThreadDemo {
    final static int KEY = 50000;
    public static void main(String[] args) {
        SubThread subThread = new SubThread();
        subThread.start();
        for (int i = 0; i < KEY; i++) {
            System.out.println("main..."+i);
        }
    }
}
