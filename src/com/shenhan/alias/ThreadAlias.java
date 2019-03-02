package com.shenhan.alias;

/**
 * @Author shenhan
 * @Date: 2019/3/2 15:44
 * @Description:
 */
public class ThreadAlias {
    public static void main(String[] args) {
        NameThread nt = new NameThread();
        nt.setName("wangcai");
        nt.start();
        System.out.println(Thread.currentThread().getName());
    }
}
