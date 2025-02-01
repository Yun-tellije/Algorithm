package algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class S2_15663 {

    static int n, m;
    static int[] arr, seq;
    static boolean[] visit;
    static LinkedHashSet<String> ans;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        seq = new int[m];
        visit = new boolean[n];
        ans = new LinkedHashSet<>();

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0);

        for (String s : ans) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int depth) {
        if (depth == m) {
            StringBuilder sb = new StringBuilder();
            for (int i : seq) {
                sb.append(i).append(" ");
            }
            ans.add(sb.toString());
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                seq[depth] = arr[i];
                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }
}
