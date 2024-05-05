package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_1003 {

    static int[][] fib = new int[41][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        fib[0][0] = 1;
        fib[0][1] = 0;
        fib[1][0] = 0;
        fib[1][1] = 1;

        for (int i = 2; i < 41; i++) {
            fib[i][0] = fib[i - 1][0] + fib[i - 2][0];
            fib[i][1] = fib[i - 1][1] + fib[i - 2][1];
        }

        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            sb.append(fib[a][0]).append(" ").append(fib[a][1]);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}