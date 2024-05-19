package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_9461 {

    static Long[] arr = new Long[101];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        arr[0] = 0L;
        arr[1] = 1L;
        arr[2] = 1L;
        arr[3] = 1L;

        for (int i = 0; i < n; i++) {
            sb.append(dp(Integer.parseInt(br.readLine()))).append("\n");
        }

        System.out.println(sb);
    }

    static long dp(int n) {
        if (arr[n] == null) {
            arr[n] = dp(n - 2) + dp(n - 3);
        }

        return arr[n];
    }
}