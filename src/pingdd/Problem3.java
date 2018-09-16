package pingdd;

import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] arr = new char[10][10];
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            char[] chars = sc.next().toCharArray();
            for (int j = 0; j < m; j++) {
                arr[i][j] = chars[j];
            }
        }

        for (int j = 0; j < m; j++) {
            int flag = -1;
            for (int i = n-1; i >= 0; i--) {
                if(arr[i][j] == 'x'){
                    flag = i;
                }else if(arr[i][j] == 'o'){
                    if(flag == -1){
                        arr[i][j] = '.';
                    }else if(i != flag-1){
                        arr[i][j] = '.';
                        arr[flag-1][j] = 'o';
                        flag--;
                    }else if(i == flag-1){
                        flag--;
                    }
                }else{
                    continue;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}