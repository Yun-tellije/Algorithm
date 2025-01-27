package algorithm.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2_21736 {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static char[][] arr;
    static boolean[][] visit;
    static int n, m;
    static int initX, initY;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String s = bf.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j);

                if (arr[i][j] == 'I') {
                    initX = i;
                    initY = j;
                }
            }
        }

        bfs();

        System.out.println(count == 0 ? "TT" : count);
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {initX, initY});
        visit[initX][initY] = true;

        while(!q.isEmpty()) {
            int x = q.peek()[0];
            int y = q.peek()[1];
            q.poll();

            for (int i = 0; i < 4; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];

                if (cx >= 0 && cx < n && cy >= 0 && cy < m && !visit[cx][cy]) {
                    if (arr[cx][cy] != 'X') {
                        if (arr[cx][cy] == 'P') {
                            count++;
                        }
                        q.add(new int[]{cx, cy});
                        visit[cx][cy] = true;
                    }
                }
            }
        }
    }
}
