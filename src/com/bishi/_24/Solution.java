package com.bishi._24;

public class Solution {
    static int time1 = 0,  time2 = 0;
    public static int solve(int[] time) {
        if(time == null || time.length == 0) return  0;
        int res = 0;
        int min = Integer.MAX_VALUE;
        int len = time.length;
        for(int i = 0; i < len; i ++) {
            // find min
            if(time[i] < min) {
                time1 = i;
                min = time[i];
            } else if (time[i] - min > res) {
                time2 = i;
                res = time[i] - min;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int res = solve(new int[]{4, 5, 1, 3, 6});
        System.out.println(res);
        System.out.println(time1);
        System.out.println(time2);
        res = solve(new int[]{9,2,5,4,7,4});
        System.out.println(time1);
        System.out.println(time2);
        System.out.println(res);
    }
}
