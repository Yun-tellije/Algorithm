package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_1018 {

    static int n, m;
    static boolean[][] arr;
    static int min = 64;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            for (int j = 0; j < m; j++) {
                if (s.charAt(j) == 'W') {
                    arr[i][j] = true;
                } else {
                    arr[i][j] = false;
                }
            }
        }

        int N = n - 7;
        int M = m - 7;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                find(i, j);
            }
        }

        System.out.println(min);

    }

    public static void find(int x, int y) {
        int last_x = x + 8;
        int last_y = y + 8;
        int count = 0;
        boolean temp = arr[x][y];

        for (int i = x; i < last_x; i++) {
            for (int j = y; j < last_y; j++) {
                if (temp != arr[i][j])
                    count++;

                temp = !temp;
            }
            temp = !temp;
        }

        count = Math.min(count, 64 - count);

        min = Math.min(min, count);
    }

}