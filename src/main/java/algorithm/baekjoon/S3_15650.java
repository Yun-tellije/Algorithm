package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_15650 {

    static int n;
    static int m;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];

        dfs(0, 0);

        System.out.println(sb);
    }

    static void dfs(int idx, int depth) {
        if (m == depth) {
            for (int t : arr) {
                sb.append(t).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = idx; i < n; i++) {
            arr[depth] = i + 1;
            dfs(i + 1, depth + 1);
        }
    }
}
