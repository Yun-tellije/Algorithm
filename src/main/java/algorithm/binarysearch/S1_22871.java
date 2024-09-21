package algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_22871 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n + 1];
        long[] sum = new long[n + 1];

        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sum[1] = 0;
        for (int i = 2; i <= n; i++) {
            sum[i] = Integer.MAX_VALUE;

            for (int j = 1; j < i; j++) {
                long k = cal(j, i, arr[i], arr[j]);
                k = Math.max(k, sum[j]);
                sum[i] = Math.min(sum[i], k);
            }
        }

        sb.append(sum[n]);
        System.out.println(sb);
    }

    static long cal(int i, int j, int start, int end) {
        return (long) (j - i) * (1 + Math.abs(start - end));
    }
}
