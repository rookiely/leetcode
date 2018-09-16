package jd.problem2;

import java.util.*;

class Node{
    int a,b,c;

    public Node(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int count = 0;
        List<Node> list = new ArrayList<>();
        for(int i = 0 ; i < num ; i++){
            Node node = new Node(sc.nextInt(),sc.nextInt(),sc.nextInt());
            list.add(node);
        }
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.a < o2.a) {
                    return 1;
                } else if (o1.a == o2.a) {
                    if (o1.b < o2.b) {
                        return 1;
                    } else if (o1.b == o2.b) {
                        if (o1.c < o2.c) {
                            return 1;
                        } else if (o1.c == o2.c) {
                            return 0;
                        } else {
                            return -1;
                        }
                    } else {
                        return -1;
                    }
                } else {
                    return -1;
                }
            }
        });
        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); ) {
                int temA = list.get(i).a;
                int temB = list.get(i).b;
                int temC = list.get(i).c;
                if (temA > list.get(j).a && temB > list.get(j).b
                        && temC > list.get(j).c) {
                    list.remove(j);count++;
                    continue;
                }else{
                    j++;
                }
            }
        }
        System.out.println(count);
    }
}