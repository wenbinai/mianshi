package com.bishi._17;

class P {
    void f(int i) {
        System.out.println(i);
    }
}

class Q extends P {
    void f(int i) {
        System.out.println(2 * i);
    }
}

public class Solution {
    public static void main(String[] args) {
        P x = new Q();
        Q y = new Q();
        P z = new Q();
        x.f(1);
        ((P)y).f(1);
        z.f(1);

//        int s = 1, end = 5;
//        int acc = 0;
//        while (s <= end) {
//            if (s % 2 == 0)
//                acc += s;
//            else
//                acc += end;
//            s++;
//        }
//        System.out.println(acc);
    }
}
