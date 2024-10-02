package algorithm.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_2961 {

    static int n;
    static int[] S;
    static int[] B;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        S = new int[n];
        B = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            S[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 1, 0, 0);
        System.out.println(answer);
    }

    static void dfs(int depth, int s, int b, int select) {
        if (depth == n) {
            if(select != 0) {
                answer = Math.min(answer, Math.abs(s - b));
            }
            return;
        }
        dfs(depth + 1, s*S[depth], b + B[depth], select + 1);
        dfs(depth + 1, s, b, select);
    }
}
