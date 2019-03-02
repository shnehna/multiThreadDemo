package com.shenhan;

/**
 * @Author shenhan
 * @Date: 2019/3/2 11:33
 * @Description: 定义一个Thread类的子类
 */
public class SubThread extends Thread {

    static final int KEY_NUM = 50000;

    @Override
    public void run() {
        for (int i = 0; i < KEY_NUM; i++) {
            System.out.println("run..."+i);
        }
    }
}
