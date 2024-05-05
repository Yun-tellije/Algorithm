package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_2606 {

    static int count = 0;
    static int[][]arr;
    static boolean[] check;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        arr = new int[n + 1][n + 1];
        check = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            arr[n1][n2] = arr[n2][n1] = 1;
        }

        dfs(1);
        sb.append(count);
        System.out.println(sb);
    }

    static void dfs(int start) {
        check[start] = true;

        for (int i = 1; i < arr.length; i++) {
            if (arr[start][i] == 1 && !check[i]) {
                count++;
                dfs(i);
            }
        }
    }
}