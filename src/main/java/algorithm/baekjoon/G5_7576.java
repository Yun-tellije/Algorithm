package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_7576 {

    static int[][] arr;
    static int n;
    static int m;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    queue.add(new int[] {i, j});
                }
            }
        }

        bfs();

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    max = -1;
                    break;
                }
                if (arr[i][j] - 1 > max) {
                    max = arr[i][j] - 1;
                }
            }
            if (max == -1)
                break;
        }

        sb.append(max);

        System.out.println(sb);
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            int a = queue.peek()[0];
            int b = queue.peek()[1];
            queue.poll();

            for (int i = 0; i < 4; i++) {
                int cx = a + dx[i];
                int cy = b + dy[i];

                if (cx >= 0 && cx < n && cy >= 0 && cy < m) {
                    if (arr[cx][cy] == 0) { // 익지 않은 토마토인지 판단
                        queue.add(new int[] {cx, cy});
                        arr[cx][cy] = arr[a][b] + 1;
                    }
                }
            }
        }
    }
}