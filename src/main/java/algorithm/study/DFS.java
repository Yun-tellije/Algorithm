package algorithm.study;

import java.util.Queue;
import java.util.Scanner;

/**
 * 깊이 우선 탐색
 */
public class DFS {

    public static int[][] arr;
    public static boolean[] visit;
    public static Queue<Integer> queue;
    public static int N;
    public static int V;
    public static int M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();

        arr = new int[1001][1001];
        visit = new boolean[1001];

        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = arr[b][a] = 1;
        }

        dfs(V);
    }

    public static void dfs(int start) {
        visit[start] = true;
        System.out.print(start + " ");
        for (int i = 1; i <= N; i++) {
            if (arr[start][i] == 1 && visit[i] == false) {
                dfs(i);
            }
        }
    }
}
