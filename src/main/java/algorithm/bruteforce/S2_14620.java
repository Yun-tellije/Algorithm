package algorithm.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_14620 {

    static int n;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());
        arr = new int[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    static void dfs(int depth, int sum) {
        if (sum >= answer) {
            return;
        }
        if (depth == 3) {
            answer = Math.min(sum, answer);
        } else {
            for (int i = 1; i < n - 1; i++) {
                for (int j = 1; j < n - 1; j++) {
                    if (!visit[i][j] && checkVisit(i, j)) {
                        dfs(depth + 1, sum + sumCost(i, j));

                        visit[i][j] = false;
                        for (int k = 0; k < 4; k++) {
                            visit[i + dx[k]][j + dy[k]] = false;
                        }
                    }
                }
            }
        }
    }

    static boolean checkVisit(int x, int y) {
        for (int i = 0; i < 4; i++) {
            if (visit[x + dx[i]][y + dy[i]])
                return false;
        }
        return true;
    }

    static int sumCost(int x, int y) {
        int s = arr[x][y];
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            s += arr[cx][cy];
            visit[cx][cy] = true;
        }

        return s;
    }
}
