import java.io.*;
import java.util.*;

public class Main {

    static final int INF = 1_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                arr[i][j] = INF;
            }
        }

        StringTokenizer st;
        while(true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1) break;

            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

        int min = INF;
        int[] score = new int[n + 1];
        int count = 0;

        for (int i = 1; i <= n; i++) {
            int cur = 0;
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] != INF) {
                    cur = Math.max(cur, arr[i][j]);
                }
            }

            score[i] = cur;
            if (min > cur) {
                count = 0;
                min = cur;
            }

            if (min == cur) count++;
        }

        sb.append(min).append(" ").append(count).append("\n");

        for (int i = 1; i <= n; i++) {
            if (score[i] == min) sb.append(i).append(" ");
        }

        System.out.println(sb);
    }
}
