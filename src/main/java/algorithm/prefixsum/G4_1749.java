package algorithm.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_1749 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 1; j <= m; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1] + num;
            }
        }

        int max = arr[1][1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 0; k < i; k++) {
                    for (int l = 0; l < j; l++) {
                        max = Math.max(max, arr[i][j] - arr[k][j] - arr[i][l] + arr[k][l]);
                    }
                }
            }
        }

        sb.append(max);

        System.out.println(sb);
    }
}
