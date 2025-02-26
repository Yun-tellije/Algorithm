package algorithm.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SW_TEST_4008 {

    static int max, min, n;
    static int[] arr, op;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;

            n = Integer.parseInt(br.readLine());
            op = new int[4];
            arr = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                op[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(1, arr[0]);

            sb.append("#").append(t).append(" ").append(max - min).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int depth, int sum) {
        if (depth == n) {
            min = Math.min(sum, min);
            max = Math.max(sum, max);

            return;
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) {
                op[i]--;

                int temp = sum;

                if (i == 0) {
                    temp += arr[depth];
                } else if (i == 1) {
                    temp -= arr[depth];
                } else if (i == 2) {
                    temp *= arr[depth];
                } else {
                    temp /= arr[depth];
                }

                dfs(depth + 1, temp);
                op[i]++;
            }
        }
    }
}
