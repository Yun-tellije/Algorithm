package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B3_30802 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[6];

        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine());

        int t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int sum = 0;

        for (int i = 0; i < 6; i++) {
            if (arr[i] % t == 0) {
                sum += arr[i] / t;
            } else {
                sum += arr[i] / t + 1;
            }
        }

        sb.append(sum + "\n");
        sb.append(n / p + " " + n % p);

        System.out.println(sb);

    }
}
