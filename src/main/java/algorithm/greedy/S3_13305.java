package algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_13305 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        long[] r = new long[n - 1];
        long[] arr = new long[n];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n - 1; i++) {
            r[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        long min = arr[0];
        long sum = 0;

        for (int i = 0; i < n - 1; i++) {
            min = Math.min(arr[i], min);

            sum += min * r[i];
        }

        System.out.println(sum);
    }
}
