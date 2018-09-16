package pingdd;

import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[] flag = new int[1000000];
        int len = 1;
        if (a > b) {
            a = a % b;
        }
        while (a != 0) {
            if (flag[a] == 0) {
                flag[a] = len;
            } else {
                System.out.print(flag[a]-1+" ");
                System.out.print(len - flag[a]);
                return;
            }
            len++;
            a = a * 10 % b;
        }
        System.out.print(len-1+" ");
        System.out.print(0);
    }
}
