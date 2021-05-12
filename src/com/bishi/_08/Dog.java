package com.bishi._08;

public class Dog extends Animal {
    public static void getName() {
        System.out.println("返回狗姓名");
    }

    @Override
    public void move() {
        System.out.println("狗在叫");
    }

    public void move(String name) {
        System.out.println("name" + "狗在叫");
    }
}
