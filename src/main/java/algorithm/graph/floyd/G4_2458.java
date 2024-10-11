package algorithm.graph.floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_2458 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] += 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (arr[i][k] >= 1 && arr[k][j] >= 1) {
                        arr[i][j] = arr[k][j] + 1;
                    }
                }
            }
        }

        int sum = 0;

        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] > 0 || arr[j][i] > 0) {
                    int max = Math.max(arr[i][j], arr[j][i]);
                    arr[i][j] = max;
                    arr[j][i] = max;
                    cnt++;
                }
            }

            if (cnt == (n - 1))
                sum++;
        }

        System.out.println(sum);
    }
}
