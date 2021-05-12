package com.bishi._11;

public class SingleDemo {
    private volatile static SingleDemo instance;

    private SingleDemo() {
    }

    public static SingleDemo getInstance() {
        if (instance == null) {
            synchronized (SingleDemo.class) {
                if (instance == null) {
                    instance = new SingleDemo();
                }
            }
        }
        return instance;
    }
}
