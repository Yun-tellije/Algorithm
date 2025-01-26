package algorithm.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_7569 {

    static int[] dx = {1, -1};
    static int[] dy = {0, 0, -1, 1};
    static int[] dz = {1, -1, 0, 0};
    static int n, m, h;
    static int[][][] arr;
    static boolean[][][] visit;
    static Queue<int[]> q = new LinkedList<>();
    static int maxCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        arr = new int[h][m][n];
        visit = new boolean[h][m][n];
        // 1 -> 익은 토마토
        // 0 -> 익지 않은 토마토
        // -1 -> 토마토 없음

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(bf.readLine());
                for (int k = 0; k < n; k++) {
                   arr[i][j][k] = Integer.parseInt(st.nextToken());
                   if (arr[i][j][k] == 1) {
                       q.add(new int[] {i, j, k, 0});
                   }
                }
            }
        }

        bfs();
        boolean check = ripeCheck();

        if (check) {
            System.out.println(maxCount);
        } else {
            System.out.println(-1);
        }
    }

    static void bfs() {
        while (!q.isEmpty()) {
            int x = q.peek()[0];
            int y = q.peek()[1];
            int z = q.peek()[2];
            int count = q.peek()[3];
            q.poll();

            visit[x][y][z] = true;
            maxCount = Math.max(maxCount, count);

            for (int i = 0; i < 4; i++) {
                int cy = dy[i] + y;
                int cz = dz[i] + z;

                if (cy >= 0 && cy < m && cz >= 0 && cz < n && arr[x][cy][cz] == 0) {
                    if (!visit[x][cy][cz]) {
                        visit[x][cy][cz] = true;
                        arr[x][cy][cz] = 1;
                        q.add(new int[] {x, cy, cz, count + 1});
                    }
                }
            }

            for (int i = 0; i < 2; i++) {
                int cx = dx[i] + x;

                if (cx >= 0 && cx < h && arr[cx][y][z] == 0) {
                    if (!visit[cx][y][z]) {
                        visit[cx][y][z] = true;
                        arr[cx][y][z] = 1;
                        q.add(new int[] {cx, y, z, count + 1});
                    }
                }
            }
        }
    }

    static boolean ripeCheck() {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    if (arr[i][j][k] == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
