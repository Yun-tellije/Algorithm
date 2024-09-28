package algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G1_1561 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(bf.readLine());
        long n = Long.parseLong(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr =  new int[m + 1];

        int max = 0;
        st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        if (n <= m) {
            sb.append(n);
        } else {
            long left = 0;
            long right = n * 30L;

            while (left <= right) {
                long mid = (left + right) / 2;
                long sum = m;

                for (int i = 1; i <= m; i++) {
                    sum += mid / arr[i];
                }

                if (sum < n) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            long cnt = m;

            for (int i = 1; i <= m; i++) {
                cnt += (left - 1) / arr[i];
            }

            for (int i = 1; i <= m; i++) {
                if ((left) % arr[i] == 0) {
                    cnt++;
                }

                if (cnt == n) {
                    sb.append(i);
                    break;
                }
            }
        }

        System.out.println(sb);
    }
}
