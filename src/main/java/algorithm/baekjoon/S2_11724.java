package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2_11724 {

    static ArrayList<Boolean> visit = new ArrayList<>();
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[u][v] = arr[v][u] = 1;
        }

        for (int i = 0; i <= n; i++) {
            visit.add(false);
        }

        visit.set(0, true);

        int count = 1;
        bfs(1);

        while (true) {
            if (visit.contains(false)) {
                for (int i = 1; i <= n; i++) {
                    if (!visit.get(i)) {
                        bfs(i);
                        count++;
                    }
                }
            }
            else {
                break;
            }
        }

        sb.append(count);

        System.out.println(sb);
    }

    public static void bfs(int start) {
        visit.set(start, true);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()) {
            int temp = queue.poll();

            for (int i = 0; i < arr.length; i++) {
                if (arr[temp][i] == 1 && visit.get(i) == false) {
                    queue.add(i);
                    visit.set(i, true);
                }
            }
        }

    }
}