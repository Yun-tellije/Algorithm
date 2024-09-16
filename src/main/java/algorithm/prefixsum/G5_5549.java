package algorithm.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_5549 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][][] arr = new int[n + 1][m + 1][3];

        int k = Integer.parseInt(bf.readLine());

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(bf.readLine());
            String s = st.nextToken();

            for (int j = 1; j <= m; j++) {
                char c = s.charAt(j - 1);

                for (int t = 0; t < 3; t++) {
                    arr[i][j][t] = arr[i - 1][j][t] + arr[i][j - 1][t] - arr[i - 1][j - 1][t];
                }
                switch (c) {
                    case 'J':
                        arr[i][j][0]++;
                        break;
                    case 'O':
                        arr[i][j][1]++;
                        break;
                    case 'I':
                        arr[i][j][2]++;
                        break;
                }
            }
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(bf.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            for (int j = 0; j < 3; j++) {
                sb.append(arr[c][d][j] - arr[a - 1][d][j] - arr[c][b - 1][j] + arr[a - 1][b - 1][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
