package com.bishi._15;

import java.util.Scanner;
import java.util.logging.Logger;

class Info {
    int time;
    boolean state;

    public Info() {
        time = 0;
        state = false;
    }
}

public class Main {
    public static Info[] infos;
    public static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strs = str.split(" ");
        n = Integer.valueOf(strs[0]);
        Logger logger = Logger.getLogger("Main.class");
        logger.info("n: " + n);
        infos = new Info[n];
        for (int i = 0; i < n; i++) {
            infos[i] = new Info();
        }
        int m = Integer.valueOf(strs[1]);
        str = scanner.nextLine();
        strs = str.split(" ");
        int tmp;
        for (int i = 0; i < m; i++) {
            tmp = Integer.valueOf(strs[i]);
            change(tmp-1, i+1);
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = infos[i].time;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }

    public static void change(int val, int i) {
        for (int j = val; j < n; j++) {
            infos[j].state = !infos[j].state;
            if (infos[j].state)
                infos[j].time = i;
        }
    }
}
