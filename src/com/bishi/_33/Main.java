package com.bishi._33;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strs = s.split(" ");
        int n = Integer.parseInt(strs[0]);
        int q = Integer.parseInt(strs[1]);
        s = sc.nextLine();
        List<Integer> list = new ArrayList<>();
        String[] split = s.split(" ");
        for (String str : split) {
            list.add(Integer.parseInt(str));
        }
        for (int i = 0; i < q; i++) {
            int m = sc.nextInt();
            boolean help = helper(list, m);
            if (!help) {
                System.out.println("NO");
            }
        }

    }

    static boolean helper(List<Integer> list, int s) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        int sum = 0;
        int count = 0;
        for (Integer integer : list) {
            count++;
            sum += integer;
        }
        if (sum == s) {
            System.out.println("YES");
            return true;
        } else if (count == 1 && sum != s) {
            return false;
        } else {
            int avg = sum / count;
            List<Integer> moreList = list.stream()
                    .filter(item -> item > avg)
                    .collect(Collectors.toList());
            List<Integer> lessList = list.stream()
                    .filter(item -> item <= avg)
                    .collect(Collectors.toList());
            return helper(moreList, s) || helper(lessList, s);
        }
    }
}
