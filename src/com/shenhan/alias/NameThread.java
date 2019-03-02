package com.shenhan.alias;

/**
 * @Author shenhan
 * @Date: 2019/3/2 15:45
 * @Description:
 */
public class NameThread extends Thread {
    public NameThread() {
        super("小强");
    }

    @Override
    public void run() {
        System.out.println(getName());
    }
}
