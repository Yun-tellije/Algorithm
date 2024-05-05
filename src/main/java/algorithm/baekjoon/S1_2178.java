package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1_2178 {

    public static int[][] arr;
    public static boolean [][] visit;
    public static int count = 0;
    public static int n;
    public static int m;
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        bfs(0, 0);
        System.out.println(arr[n - 1][m - 1]);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visit[x][y] = true;

        while (!queue.isEmpty()) {
            int[] a = queue.poll();
            int x1 = a[0];
            int y1 = a[1];


            for (int i = 0; i < 4; i++) {
                int x2 = x1 + dx[i];
                int y2 = y1 + dy[i];

                if (x2 < 0 || x2 >= n || y2 < 0 || y2 >= m)
                    continue;

                if (arr[x2][y2] == 1 && !visit[x2][y2]) {

                    queue.add(new int[]{x2, y2});
                    visit[x2][y2] = true;
                    arr[x2][y2] = arr[x1][y1] + 1;
                }
            }
        }
    }
}