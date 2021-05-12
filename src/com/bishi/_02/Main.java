package com.bishi._02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        User[] users = new User[100005];
        for (int i = 0; i < n; i++) {
            users[i].arrTime = sc.nextInt();
            users[i].playTime = sc.nextInt();
        }
        users[0].endTime = users[0].arrTime + users[0].playTime;

        for (int i = 1; i < n; i++) {
            if (users[i].arrTime > users[i - 1].endTime) {
                users[i].endTime = users[i].arrTime + users[i].playTime;
            } else {
                users[i].endTime = users[i - 1].endTime + users[i].playTime;
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res += (users[i].endTime - users[i].arrTime);
        }
        System.out.println(res);
    }
}

class User {
    int arrTime;
    int playTime;
    int endTime;
}