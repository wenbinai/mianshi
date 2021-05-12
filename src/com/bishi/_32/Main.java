package com.bishi._32;

import java.util.*;

public class Main {
    static class Product {
        public String name;
        public int sale;
        public int count;


        public Product(String name, int sale, int count) {
            this.name = name;
            this.sale = sale;
            this.count = count;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] strs = s.split(" ");
        int n = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);
        Map<String, Product> products = new HashMap<>();
        for (int i = 0; i < n; i++) {
            s = scanner.nextLine();
            String[] strings = s.split(" ");
            Product product = new Product(strings[0],
                    Integer.parseInt(strings[1]),
                    Integer.parseInt(strings[2]));
            products.put(strings[0], product);
        }
        String[] productNames = new String[m];
        int[] productCounts = new int[m];
        for (int i = 0; i < m; i++) {
            s = scanner.nextLine();
            String[] split = s.split(" ");
            productNames[i] = split[0];
            productCounts[i] = Integer.parseInt(split[1]);
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            Product product = products.get(productNames[i]);
            if (product == null) {
                res = -(i + 1);
                break;
            } else {
                product.count -= productCounts[i];
                res += productCounts[i] * product.sale;
                if (product.count < 0) {
                    res = -(i + 1);
                    break;
                }
            }
        }
        System.out.println(res);
    }
}
