package jd.problem1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int flag[][] = new int[1000][1000];
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            int N = sc.nextInt();
            int M = sc.nextInt();
            for (int j = 0; j < M; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                flag[x][y] = 1;
                flag[y][x] = 1;
            }
            list1.add(1);
            for (int j = 2; j <= N; j++) {
                if (flag[1][j] == 0) {
                    list1.add(j);
                }else{
                    list2.add(j);
                }
            }
            boolean f = false;
            for (int j = 0; j < list1.size(); j++) {
                for (int k = j; k < list1.size(); k++) {
                    if (flag[list1.get(j)][list1.get(k)] == 0) {
                        continue;
                    }else{
                        System.out.println("No");
                        f = true;
                        break;
                    }
                }
                if (f) {
                    break;
                }
            }
            if (f) {
                continue;
            }else {
                for (int j = 0; j < list1.size(); j++) {
                    for (int k = 0; k < list2.size(); k++) {
                        if (flag[list1.get(j)][list2.get(k)] == 1) {
                            continue;
                        }else{
                            System.out.println("No");
                            f = true;
                            break;
                        }
                    }
                    if (f) {
                        break;
                    }
                }
                if (!f) {
                    System.out.println("Yes");
                }
            }
        }
    }
}