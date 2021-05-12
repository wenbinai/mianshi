package com.bishi._30;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int n = in.nextInt();
        String[] strs = str.split(",");
        int sum = 0;
        for(String s : strs) {
            sum += Integer.parseInt(s);
        }
        int res, last;
        if(sum % n == 0) {
            res = sum / n;
            last = res;
        } else {
            res = sum / n + 1;
            last = sum - res * n;
        }
        for(int i = 0; i < n - 1; i ++) {
            System.out.print(res);
        }
        System.out.println(last);
    }
}
