package algorithm.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D2_1961 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(bf.readLine());

        for (int T = 1; T <= tc; T++) {
            int n = Integer.parseInt(bf.readLine());
            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] answer1 = new int[n][n];
            int[][] answer2 = new int[n][n];
            int[][] answer3 = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    answer1[i][j] = arr[n - j - 1][i];
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    answer2[i][j] = arr[n - i - 1][n - j - 1];
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    answer3[i][j] = arr[j][n - i - 1];
                }
            }

            sb.append("#" + T + "\n");

            for (int i = 0 ; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(answer1[i][j]);
                }
                sb.append(" ");
                for (int j = 0; j < n; j++) {
                    sb.append(answer2[i][j]);
                }
                sb.append(" ");
                for (int j = 0; j < n; j++) {
                    sb.append(answer3[i][j]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
