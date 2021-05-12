package com.bishi._10;

import java.util.Scanner;

public class Main {
    static int[] a = new int[50005];
    static boolean[] vis = new boolean[50005];
    // 类似数字全排列的思路
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.nextLine();
        String[] strs = s.split(" ");

        for (int i = 0; i < n; i++) {
            a[i] = Integer.valueOf(strs[i]);
        }
    }
    private static void bfs(int level) {
        if(level == 2) {

        }
        bfs(level+1);
    }
}
