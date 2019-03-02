package com.shenhan.anonymousinner;

/**
 * @Author shenhan
 * @Date: 2019/3/2 16:36
 * @Description: 匿名内部类
 */
public class AnonymousInnerClass {
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                System.out.println("!!!");
            }
        }.start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("###");
            }
        }).start();
    }
}
