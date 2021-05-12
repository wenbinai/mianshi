package com.bishi._13;

public class Solution {
    public static boolean chkMixture(String A, int n, String B, int m, String C, int v) {
        // write code here
        if (n + m != v) return false;
        StringBuilder SA = new StringBuilder(A);
        StringBuilder SB = new StringBuilder(B);
        StringBuilder SC = new StringBuilder(C);
        for (int i = 0; i < SC.length(); i++) {
            for (int j = 0; j < SA.length(); j++) {
                if (SC.charAt(i) == SA.charAt(j)) {
                    SA.replace(j, j+1, "+");
                    SC.replace(i, i+1, "-");
                }
            }
        }
        for(int i = 0; i < SC.length(); i ++) {
            for (int j = 0; j < SB.length(); j++) {
                if (SC.charAt(i) == SB.charAt(j)) {
                    SC.replace(i, i+1, "-");
                    SB.replace(j, j+1, "+");
                }
            }
        }
        for (int i = 0; i < SC.length(); i++) {
            if (SC.charAt(i) != '-') return false;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean flag = chkMixture("ABC", 3, "12C", 3, "A12BCC", 6);
        System.out.println(flag);
    }
}
