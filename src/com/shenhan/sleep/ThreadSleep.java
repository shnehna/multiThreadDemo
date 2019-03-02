package com.shenhan.sleep;

/**
 * @Author shenhan
 * @Date: 2019/3/2 16:00
 * @Description: 休眠
 */
public class ThreadSleep extends Thread{
    /*public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.println(i);
        }
    }*/

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }
}
