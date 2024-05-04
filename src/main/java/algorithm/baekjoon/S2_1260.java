package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2_1260 {

    public static int[][] arr;
    public static int N;
    public static int M;
    public static int V;
    public static Queue<Integer> queue;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        arr = new int[1001][1001];
        visit = new boolean[1001];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] = 1;
        }

        dfs(V);
        Arrays.fill(visit, false);
        sb.append("\n");
        bfs(V);
        System.out.println(sb);
    }

    public static void dfs(int start) {
        visit[start] = true;
        sb.append(start).append(" ");

        for (int i = 1; i <= N; i++) {
            if (arr[start][i] == 1 && !visit[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int start) {
        visit[start] = true;
        queue = new LinkedList<Integer>();
        queue.add(start);
        sb.append(start).append(" ");

        while (!queue.isEmpty()) {
            int a = queue.poll();

            for (int i = 0; i < arr.length; i++) {
                if (arr[a][i] == 1 && !visit[i]) {
                    queue.add(i);
                    visit[i] = true;
                    sb.append(i).append(" ");
                }
            }
        }
    }
}