package algorithm.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D2_1959 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(bf.readLine());

        for (int T = 1; T <= tc; T++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int[] arr1 = new int[a];
            int[] arr2 = new int[b];

            st = new StringTokenizer(bf.readLine());
            for (int i = 0 ; i < a; i++) {
                arr1[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(bf.readLine());
            for (int i = 0 ; i < b; i++) {
                arr2[i] = Integer.parseInt(st.nextToken());
            }

            int max = 0;
            if (a < b) {
                for (int i = 0; i < (b - a + 1); i++) {
                    int sum = 0;
                    for (int j = 0; j < a; j++) {
                        sum += arr1[j] * arr2[i + j];
                    }
                    max = Math.max(max, sum);
                }
            } else {
                for (int i = 0; i < (a - b + 1); i++) {
                    int sum = 0;
                    for (int j = 0; j < b; j++) {
                        sum += arr1[i + j] * arr2[j];
                    }
                    max = Math.max(max, sum);
                }
            }


            sb.append("#").append(T).append(" ").append(max).append("\n");
        }

        System.out.println(sb);
    }
}
