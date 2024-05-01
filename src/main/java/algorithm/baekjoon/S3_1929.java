package algorithm.baekjoon;

import java.util.Scanner;

public class S3_1929 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int m = sc.nextInt();
        int n = sc.nextInt();
        boolean b;

        for (int i = m; i <= n; i++) {
            b = true;

            for (int j = 2; j*j <= i; j++) {
                if (i % j == 0) {
                    b = false;
                }
            }

            if (b)
                sb.append(i).append("\n");
        }

        System.out.println(sb);
    }
}