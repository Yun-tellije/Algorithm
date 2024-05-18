package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_1149 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    arr[i][j] += Math.min(arr[i - 1][1], arr[i - 1][2]);
                }
                else if (j == 1) {
                    arr[i][j] += Math.min(arr[i - 1][0], arr[i - 1][2]);
                }
                else {
                    arr[i][j] += Math.min(arr[i - 1][0], arr[i - 1][1]);
                }
            }
        }

        int min = arr[n - 1][0];
        for (int i = 1; i < 3; i++) {
            if (arr[n - 1][i] < min)
                min = arr[n - 1][i];
        }
        sb.append(min);

        System.out.println(sb);
    }
}