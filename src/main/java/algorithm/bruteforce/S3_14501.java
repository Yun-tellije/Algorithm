package algorithm.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_14501 {

    static int[][] arr;
    static int answer;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(bf.readLine());
        arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        a(0, 0);

        sb.append(answer);
        System.out.println(sb);

    }

    static void a(int idx, int num) {
        if (idx >= n) {
            answer = Math.max(num, answer);
            return;
        }

        if (idx + arr[idx][0] <= n) {
            a(idx + arr[idx][0], num + arr[idx][1]);
        } else {
            a(idx + arr[idx][0], num);
        }

        a(idx + 1, num);
    }
}
