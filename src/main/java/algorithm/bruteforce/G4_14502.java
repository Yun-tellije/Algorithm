package algorithm.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G4_14502 {

    static int n, m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] arr;
    static int max;

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());

            for (int j = 0 ; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        sb.append(max);
        System.out.println(sb);
    }

    static void dfs(int cnt) {
        if (cnt == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    dfs(cnt + 1);
                    arr[i][j] = 0;
                }
            }
        }
    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        int[][] temp = new int[n][m];

        for (int i = 0; i < n; i++) {
            temp[i] = arr[i].clone();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (temp[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int ax = queue.peek()[0];
            int ay = queue.peek()[1];
            queue.poll();

            for (int i = 0; i < 4; i++) {
                int cx = ax + dx[i];
                int cy = ay + dy[i];

                if (cx >= 0 && cx < n && cy >= 0 && cy < m) {
                    if (temp[cx][cy] == 0) {
                        temp[cx][cy] = 2;
                        queue.add(new int[]{cx, cy});
                    }
                }
            }
        }

        countSafeZone(temp);
    }

    static void countSafeZone(int[][] temp) {
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (temp[i][j] == 0) {
                    cnt++;
                }
            }
        }

        max = Math.max(cnt, max);
    }
}
