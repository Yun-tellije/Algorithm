package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class S1_2667 {

    static StringBuilder sb = new StringBuilder();
    static int n;
    static int[][] arr;
    static boolean[][] visit;
    static PriorityQueue<Integer> list = new PriorityQueue<>();
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int cnt;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visit = new boolean[n][n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            for (int j = 0; j < n; j++) {
                char c = s.charAt(j);
                arr[i][j] = c - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1 && !visit[i][j]) {
                    cnt = 1;
                    dfs(i, j);
                    count++;
                    list.add(cnt);
                }
            }
        }

        sb.append(count).append("\n");

        for (int i = 0 ; i < count; i++) {
            sb.append(list.poll()).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int x, int y) {
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];
            if (cx >= 0 && cx < n && cy >= 0 && cy < n) {
                if (arr[cx][cy] == 1 && !visit[cx][cy]) {
                    cnt++;
                    dfs(cx, cy);
                }
            }
        }
    }
}