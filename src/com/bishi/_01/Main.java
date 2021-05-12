package com.bishi._01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        String[] str1s = str1.split(",");
        String[] str2s = str2.split(",");
        Map<String, String> map1 = new HashMap<>();
        for (String str : str1s) {
            String[] tmp = str.split("-");
            map1.put(tmp[0], tmp[1]);
        }
        Map<String, String> map2 = new HashMap<>();
        for (String str : str2s) {
            String[] tmp = str.split("-");
            map2.put(tmp[0], tmp[1]);
        }
        Set<String> strings = map1.keySet();
        String res = "";
        for (String str : strings) {
            if (map2.get(str) != null) {
                if (!map2.get(str).equals(map1.get(str))) {
                    res = res + "modify-" + str;
                    res += ",";
                }
            } else {
                res = res + "delete-" + str;
                res += ",";
            }
        }
        Set<String> strings1 = map2.keySet();
        for (String str : strings1) {
            if (map1.get(str) == null) {
                res = res + "add-" + str;
                res += ",";
            }
        }
        for(int i = 0; i < res.length() - 1; i ++) {
            System.out.print(res.charAt(i));
        }

    }
}
