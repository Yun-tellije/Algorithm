package algorithm.baekjoon;

import java.util.Scanner;

public class B2_2292 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 1;
        while (n > 0) {
            if (n == 1)
                break;

            if (n > answer * 6) {
                n -= answer * 6;
                answer++;
            } else {
                answer++;
                break;
            }
        }

        System.out.println(answer);
    }
}