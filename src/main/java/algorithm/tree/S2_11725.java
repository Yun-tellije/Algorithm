package algorithm.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S2_11725 {

    static int n;
    static int[] parent;
    static boolean[] visit;
    static ArrayList<Integer> list[];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(bf.readLine());
        parent = new int[n + 1];
        visit = new boolean[n + 1];
        list = new ArrayList[n + 1];

        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list[x].add(y);
            list[y].add(x);
        }

        dfs(1);

        for (int i = 2; i < n + 1; i++) {
            sb.append(parent[i]).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int idx) {
        visit[idx] = true;

        for (int i : list[idx]) {
            if (!visit[i]) {
                parent[i] = idx;
                dfs(i);
            }
        }
    }
}
