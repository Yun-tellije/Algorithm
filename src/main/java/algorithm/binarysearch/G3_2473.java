package algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G3_2473 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(bf.readLine());
        long[] arr = new long[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);
        long min = Long.MAX_VALUE;
        long[] answer = new long[3];

        for (int i = 0; i < n - 2; i++) {
            int start = i + 1;
            int end = n - 1;

            while (start < end) {
                long sum = arr[i] + arr[start] + arr[end];

                if (Math.abs(sum) < Math.abs(min)) {
                    answer[0] = arr[i];
                    answer[1] = arr[start];
                    answer[2] = arr[end];
                    min = Math.abs(sum);
                }

                if (sum <= 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        sb.append(answer[0]).append(" ").append(answer[1]).append(" ").append(answer[2]);
        System.out.println(sb);
    }

}
