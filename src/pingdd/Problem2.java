package pingdd;

import java.util.Scanner;

public class Problem2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hp = sc.nextInt();
        int na = sc.nextInt();
        int ba = sc.nextInt();
        int res;
        if (na >= (ba*1.0 / 2)) {
            res = (hp % na == 0) ? hp / na : hp / na + 1;
        } else {
            res = hp / ba * 2;
            hp = hp % ba;
            if (hp != 0) {
                if (hp / na > 2 || (hp / na == 2 && hp % na != 0)) {
                    res += 2;
                } else {
                    res += hp / na + (hp % na != 0 ? 1 : 0);
                }
            }
        }
        System.out.print(res);
    }
}
