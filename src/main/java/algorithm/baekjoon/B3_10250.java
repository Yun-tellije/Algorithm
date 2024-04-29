package algorithm.baekjoon;

import java.util.Scanner;

public class B3_10250 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        for (int i = 0; i < num; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            int n = sc.nextInt();

            int answer = n % h * 100;
            if (n % h == 0) {
                answer = h * 100;
            }

            if (n % h == 0) {
                answer += n / h;
            } else {
                answer += n / h + 1;
            }

            System.out.println(answer);
        }
    }
}
