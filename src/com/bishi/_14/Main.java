//package com.mianshi.bishi._14;
//
//
//import java.util.*;
//import java.util.logging.Logger;
//
//public class Main {
//    public static int[] tmp = new int[26];
//
//    public static void main(String[] args) {
//        Logger logger = Logger.getLogger("Main.class");
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
//        String[] strs = str.split(" ");
//        int n = Integer.valueOf(strs[0]);
//        int k = Integer.valueOf(strs[1]);
//        str = sc.nextLine();
//        char[] chars = str.toCharArray();
//        int len = str.length();
//        for (int i = 1; i < len; i++) {
//            int j = i + 1;
//            while (chars[j] == chars[i]) {
//                j ++;
//            }
//            // aabaa
//            int tmp = j + k;
//            for(int  = j; k < tmp; k ++) {
//
//            }
//            tmp[chars[i - '0']]
//        }
//        Arrays.sort(tmp);
//        System.out.println(tmp[25] + k);
//    }
//}
