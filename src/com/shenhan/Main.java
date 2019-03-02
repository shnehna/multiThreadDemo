package com.shenhan;

public class Main {

    final static int KEY_PRE = 10000;
    public static void main(String[] args) {
        function();
        System.out.println(Math.abs(-9));
    }

    public static void function() {
        for (int i = 0; i < KEY_PRE; i++) {
            System.out.println(i);
        }
    }
}
