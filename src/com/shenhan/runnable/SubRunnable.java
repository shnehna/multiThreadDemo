package com.shenhan.runnable;

/**
 * @Author shenhan
 * @Date: 2019/3/2 16:19
 * @Description: 创建线程的另一种方法 实现接口
 */
public class SubRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            System.out.println("run..."+i);
        }
    }
}
