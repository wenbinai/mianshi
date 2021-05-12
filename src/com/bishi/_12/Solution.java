package com.bishi._12;

import java.util.*;

public class Solution {
    public static int[] solve(int[] a) {
        // write code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            map.put(a[i], i + 1);
        }
        map.keySet().stream().sorted();
        map.keySet().forEach(i -> {
            System.out.println(map.get(i));
        });
        List<Integer> list = new ArrayList<>();

        int[] res = new int[a.length];
//        for (int i = 0; i < a.length; i++) {
//            res[i] = list.get(i);
//        }
        return res;
    }

    public static void main(String[] args) {
        int[] tmp = new int[]{2, 1, 5, 3, 4};
        solve(tmp);
    }
}
