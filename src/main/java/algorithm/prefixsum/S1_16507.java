package algorithm.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_16507 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[][] arr = new int[r + 1][c + 1];
        int[][] sum = new int[r + 1][c + 1];

        for (int i = 1; i <= r; i++) {
            st = new StringTokenizer(bf.readLine());

            for (int j = 1; j <= c; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                sum[i][j] = sum[i][j - 1] + arr[i][j];
            }
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(bf.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            int s = 0;
            for (int j = r1; j <= r2; j++) {
                s += sum[j][c2] - sum[j][c1 - 1];
            }

            sb.append(s / ((c2 - c1 + 1) * (r2 - r1 + 1))).append("\n");
        }

        System.out.println(sb);
    }
}
