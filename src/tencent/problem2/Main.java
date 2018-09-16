package tencent.problem2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Map<Integer, Integer> map = new HashMap<>();

    public static void dfs(int[][] city, int n, int b, int x) {
        for (int i = 1; i <= n; i++) {
            if (city[x][i] == 1) {
                city[b][i] = 1;
                if (i == x) return;
                if (map.containsKey(x)) {
                    map.put(x, map.get(x) - 1);
                } else
                    map.put(x, -1);
                if (map.containsKey(i)) {
                    map.put(x, map.get(i) + 1);
                } else
                    map.put(i, 1);
                dfs(city, n, b, i);
            }
        }
        return;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] city = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            city[a][b] = 1;
        }
        for (int i = 1; i <= n; i++) {
            dfs(city, n, i, i);
        }
        int count = 0;
        for (Integer i :
                map.keySet()) {
            if (map.get(i) > 0) {
                count++;
            }
        }
        System.out.println(count);
    }
}