package com.bishi._03;

import java.util.*;

public class Main {
    static int[][] d = new int[115][115];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strs = str.split(";");
        // 1011 1111
        String[] substrs = strs[0].split(",");
        // 1 1 1 1
        int[][] arr = new int[strs.length][substrs.length];
        int k = 0, j = 0;
        for (String s : strs) {
            String[] split = s.split(",");
            for (String tmp : split) {
                arr[k][j++] = tmp.charAt(0) - '0';
            }
            j = 0;
            k++;
        }
        if (arr[0][0] == 0) System.out.println("0");
        int res = bfs(arr);
        System.out.println(res);
    }

    private static int bfs(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        d[0][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        Queue<int[]> queue = new LinkedList<>();
        // 上 下 左 右 四个方向
        int dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int a[] = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = dx[i] + a[0], y = a[1] + dy[i];
                if (x >= 0 && x < n && y >= 0 && y < n && arr[x][y] == 1 && d[x][y] == 0) {
                    d[x][y] = d[a[0]][a[1]] + 1;
                    queue.offer(new int[]{x, y});
                }
            }
        }
        return d[n - 1][m - 1];
    }
}
