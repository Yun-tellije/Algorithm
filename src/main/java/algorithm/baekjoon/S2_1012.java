package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2_1012 {

    static int[][] arr;
    static boolean[][] visit;
    static int m;
    static int n;
    static int k;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());


        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            arr = new int[m][n];
            visit = new boolean[m][n];
            int count = 0;

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[x][y] = 1;
            }

            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    if (arr[j][k] == 1 && !visit[j][k]) {
                        bfs(j, k);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }

    public static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});

        while (!queue.isEmpty()) {
            int a = queue.peek()[0];
            int b = queue.peek()[1];
            queue.poll();
            visit[a][b] = true;

            for (int i = 0; i < 4; i++) {
                int cx = a + dx[i];
                int cy = b + dy[i];
                if (cx >= 0 && cx < m && cy >= 0 && cy < n) {
                    if (arr[cx][cy] == 1 && !visit[cx][cy]) {
                        queue.add(new int[] {cx, cy});
                        visit[cx][cy] = true;
                    }
                }
            }
        }
    }
}