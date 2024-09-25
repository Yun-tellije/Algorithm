package algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_3079 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] arr = new long[n];
        long left = Long.MAX_VALUE, right = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
            left = Math.min(left, arr[i]);
            right = Math.max(right, arr[i]);
        }

        right *= m;

        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;

            for (int i = 0; i < n; i++) {
                if (sum >= m)
                    break;

                sum += mid / arr[i];
            }

            if (sum < m) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(left);
    }
}
