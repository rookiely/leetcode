package sohucy.problem1;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String numArr = sc.nextLine();
        HashMap<String, Integer> map = new HashMap<>();
        String[] arr = numArr.split(" ");
        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])){
                System.out.println(arr[i]);
            }else
                map.put(arr[i], 1);
        }
    }
}