package algorithm.study;

import java.util.Scanner;

public class Backtracking {

    public static int[] arr;
    public static boolean[] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        arr = new int[M];
        visit = new boolean[N];
        dfs(N, M, 0);
    }

    public static void dfs(int N, int M, int depth) {

        // 재귀 깊이가 M과 같다면 배열 출력
        if (depth == M) {
            for (int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true; // 해당 노드를 방문 상태로 변경
                arr[depth] = i + 1; // 해당 깊이를 index로 하여 i + 1 값 저장
                dfs(N, M, depth + 1);

                // 방문이 끝난 후 방문하지 않은 상태로 변경
                visit[i] = false;
            }
        }
    }
}
