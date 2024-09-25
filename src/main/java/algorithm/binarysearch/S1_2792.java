package algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_2792 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[m];
        int low = 1, high = Integer.MIN_VALUE;

        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
            high = Math.max(high, arr[i]);
        }

        int answer = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            int sum = 0;

            for (int i = 0; i < m; i++) {
                sum += arr[i] / mid;

                if (arr[i] % mid != 0) {
                    sum++;
                }
            }

            if (sum > n) {
                low = mid + 1;
            } else {
                high = mid - 1;
                answer = mid;
            }
        }

        System.out.println(answer);
    }
}
