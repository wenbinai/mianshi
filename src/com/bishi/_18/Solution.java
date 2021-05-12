package com.bishi._18;

public class Solution {
    static int i = 0;
    public static int fb(int n) {
        System.out.println("Called");
        i ++;
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fb(n - 1) + fb(n - 2);
    }

    public static void main(String[] args) {
        fb(5);
        System.out.println(i);
    }
}

