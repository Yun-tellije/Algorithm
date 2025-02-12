package algorithm.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D4_1861 {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static int n;
    static int[][] arr;
    static int startRoom, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            count = 0;

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    bfs(i, j);
                }
            }

            sb.append("#").append(t).append(" ").append(startRoom).append(" ").append(count).append("\n");
        }

        System.out.println(sb);
    }

    static void bfs(int tx, int ty) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {tx, ty});

        int cnt = 1;

        while(!q.isEmpty()) {
            int x = q.peek()[0];
            int y = q.peek()[1];
            q.poll();

            for (int i = 0; i < 4; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];

                if (cx < 0 || cx >= n || cy < 0 || cy >= n) {
                    continue;
                }

                if (arr[cx][cy] == arr[x][y] + 1) {
                    cnt++;
                    q.add(new int[] {cx, cy});
                    break;
                }
            }
        }

        if (cnt == count) {
            startRoom = Math.min(arr[tx][ty], startRoom);
        } else if (cnt > count) {
            count = cnt;
            startRoom = arr[tx][ty];
        }
    }
}
