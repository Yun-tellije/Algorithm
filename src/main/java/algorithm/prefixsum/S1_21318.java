package algorithm.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_21318 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] sum = new int[n];

        for (int i = 0; i < n - 1; i++) {

            if (arr[i] > arr[i + 1]) {
                sum[i + 1] = 1;
            }

            sum[i + 1] += sum[i];
        }

        int m = Integer.parseInt(bf.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            sb.append((sum[y] - sum[x]) + "\n");
        }

        System.out.println(sb);
    }
}
