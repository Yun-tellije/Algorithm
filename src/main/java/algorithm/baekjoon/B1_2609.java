package algorithm.baekjoon;

import java.util.Scanner;

public class B1_2609 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int x = 0, y;

        if (a > b) {
            x = a;
            a = b;
            b = x;
        }

        for (int i = 1; i <= a; i++) {
            if (a % i == 0 && b % i == 0) {
                x = i;
            }
        }

        int i = 1;
        while (true) {
            if (i % a == 0 && i % b == 0) {
                y = i;
                break;
            }

            i++;
        }

        System.out.print(x + "\n" + y);

    }
}