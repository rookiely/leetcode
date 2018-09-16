package tencent.problem3;

import java.util.Scanner;

public class Main {

    public static String check(int a,int b,int c){
        for (int i = 0; i < 50; i++) {
            int test = a*i;
            if (test % b == c)
                return "YES";
            else
                continue;
        }
        return "NO";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            System.out.println(check(a,b,c));
        }
    }
}