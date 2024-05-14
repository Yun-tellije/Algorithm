package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1_14940 {

    static int[][] arr;
    static int[][] answer;
    static int n;
    static int m;
    static boolean[][] visit;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        answer = new int[n][m];
        visit = new boolean[n][m];
        int x = 0, y = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    x = i;
                    y = j;
                }
            }
        }
        bfs(x, y);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (answer[i][j] == 0 && arr[i][j] == 1) {
                    sb.append(-1).append(" ");
                }
                else {
                    sb.append(answer[i][j]).append(" ");
                }

            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});

        while (!queue.isEmpty()) {
            int a = queue.peek()[0];
            int b = queue.peek()[1];
            queue.poll();

            for (int i = 0; i < 4; i++) {
                int cx = a + dx[i];
                int cy = b + dy[i];

                if (cx >= 0 && cx < n && cy >= 0 && cy < m) {
                    if (arr[cx][cy] == 1 && !visit[cx][cy]) {
                        visit[cx][cy] = true;
                        queue.add(new int[] {cx, cy});
                        answer[cx][cy] = answer[a][b] + 1;
                    }
                }
            }
        }
    }
}