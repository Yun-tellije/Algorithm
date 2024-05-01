package algorithm.baekjoon;

import java.util.Scanner;

public class S4_2839 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        int answer = 0;

        while (N > 0) {
            if (N % 5 == 0) {
                answer += N / 5;
                break;
            } else {
                N -= 3;
                answer++;
            }

            if (N < 0) {
                answer = -1;
            }
        }
        sb.append(answer);
        System.out.println(sb);
    }
}