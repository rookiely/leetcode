package pingdd;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 题目描述：输入n个l长度的字符串，从n个字符串的每一个字符中选择一个
 * 组成一个和n个字符串都不相等的字符串
 */

public class Solution4_1 {

    public static int flag = 0;
    public static char[] ans = new char[1000];
    public static Map<String,Integer> map = new HashMap<>();
    public static char[][] arr = new char[1000][26];

    public static void findStr(int index,int l){
        if(flag == 1) return;
        if(index == l) {
            String s = new String(ans);
            if (!map.containsKey(s)) {
                System.out.print(s);
                flag = 1;
            }
            return;
        }else {
            for(int i = 0 ; i < 26 ; i++){
                if(arr[index][i] == 1){
                    ans[index] = (char)('A'+i);
                    findStr(index+1,l);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < l; j++) {
                arr[j][str.charAt(j)-'A'] = 1;
            }
            map.put(str,1);
        }
        findStr(0,l);
        if(flag == 0) System.out.print("-");
    }
}
