package algorithm.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D2_12712 {

    static int[] dx1 = {1, 1, -1, -1};
    static int[] dy1 = {1, -1, -1, 1};
    static int[] dx2 = {0, 1, 0, -1};
    static int[] dy2 = {1, 0, -1, 0};
    static int[][] arr;
    static int n;
    static int m;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(bf.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            max = 0;

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    spray(i, j);
                }
            }

            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }

    static void spray(int x, int y) {
        int sum1 = arr[x][y];
        int sum2 = arr[x][y];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < m - 1; j++) {
                int cx1 = x + dx1[i] * (j + 1);
                int cy1 = y + dy1[i] * (j + 1);

                if (cx1 >= 0 && cx1 < n && cy1 >= 0 && cy1 < n) {
                    sum1 += arr[cx1][cy1];
                }

                int cx2 = x + dx2[i] * (j + 1);
                int cy2 = y + dy2[i] * (j + 1);

                if (cx2 >= 0 && cx2 < n && cy2 >= 0 && cy2 < n) {
                    sum2 += arr[cx2][cy2];
                }
            }
        }

        max = Math.max(max, Math.max(sum1, sum2));
    }
}
