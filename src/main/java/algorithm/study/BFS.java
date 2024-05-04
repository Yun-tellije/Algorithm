package algorithm.study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 너비 우선 탐색
 * 큐 사용
 */
public class BFS {

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

        bfs(V);
    }

    public static void bfs(int start) {
        queue = new LinkedList<Integer>();
        queue.add(start);
        visit[start] = true;
        System.out.print(start + " ");

        while (!queue.isEmpty()) {
            int temp = queue.poll();

            for (int i = 1; i < arr.length; i++) {
                if (arr[temp][i] == 1 && visit[i] == false) {
                    queue.add(i);
                    visit[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }
}
