package com.bishi._04;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        test();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            String[] strs = str.split(" ");
            if ("input".equals(strs[0])) {
                if (strs.length != 4) {
                    System.out.println("输入格式错误!");
                }
                add(strs[1], strs[2], strs[3]);
            } else if ("list".equals(strs[0])) {
                if (strs.length != 3) {
                    System.out.println("输入格式错误!");
                } else {
                    list(strs[2]);
                }
            } else if ("del".equals(strs[0])) {
                if (strs.length != 2) {
                    System.out.println("输入格式错误!");
                } else {
                    del(strs[1]);
                }
            } else {
                System.out.println("输入格式错误!");
            }
        }
    }

    private static void del(String str) {
        int i = Integer.parseInt(str);
        if (i - 1 < 0 || i > employees.size()) {
            System.out.println("删除位置不存在");
        } else {
            employees.remove(i - 1);
            System.out.println("成功!");
        }
    }





    private static void list(String str) {
        int pos = Integer.parseInt(str);
        int size = employees.size();
        if (pos > size) {
            System.out.println("记录为空");
            return;
        }
        for (int i = employees.size() - 1; i >= size - pos; i--) {
            System.out.println((i + 1) + "_" + employees.get(i).getName() + "_" + employees.get(i).getMonth() + "_" + employees.get(i).getMoney() + "_" + employees.get(i).getDateTime().toString().replace("T", " "));
        }
    }

    private static void add(String name, String month, String money) {
        LocalDateTime dateTime = LocalDateTime.now();
        Employee employee = new Employee( name, BigDecimal.valueOf(Long.parseLong(money)), Integer.parseInt(month), dateTime);
        employees.add(employee);
        System.out.println(employees.size() + "_" + name + "_" + month + "_" + money + "_" + dateTime.toString().replace("T", " "));
    }

    private static void test() {
//        add("a", "10", "5000");
//        list("1");
    }
}
