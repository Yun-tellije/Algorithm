package algorithm.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_2468 {

    static int n;
    static int[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visit;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(bf.readLine());
        arr = new int[n][n];

        int max = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                max = Math.max(max, arr[i][j]);
            }
        }


        for (int i = 0; i < max; i++) {
            visit = new boolean[n][n];
            int cnt = 0;

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (!visit[j][k] && arr[j][k] > i) {
                        dfs(j, k, i);
                        cnt++;
                    }
                }
            }
            answer = Math.max(answer, cnt);
        }

        sb.append(answer);
        System.out.println(sb);
    }

    static void dfs(int x, int y, int idx) {
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if (cx >= 0 && cx < n && cy >= 0 && cy < n) {
                if (arr[cx][cy] > idx && !visit[cx][cy]) {
                    dfs(cx, cy, idx);
                }
            }
        }
    }
}
