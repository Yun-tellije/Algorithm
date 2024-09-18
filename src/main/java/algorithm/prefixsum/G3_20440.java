package algorithm.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G3_20440 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(bf.readLine());
        int[] input = new int[n];
        int[] output = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            input[i] = Integer.parseInt(st.nextToken());
            output[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input);
        Arrays.sort(output);

        int in = 0, out = 0;
        int cnt = 0; // 현재 존재하는 모기 수
        int start = 0;
        int a = 0, b = 0;

        int max = 0;

        while (in < n || out < n) {
            if (in == n) {
                if (max < cnt) {
                    max = cnt;
                    a = start;
                    b = output[out];
                }
                cnt--;
                out++;
            } else if (input[in] < output[out]) {
                cnt++;

                if (max < cnt) {
                    start = input[in];
                }
                in++;
            } else if (input[in] > output[out]) {
                if (max < cnt) {
                    max = cnt;
                    a = start;
                    b = output[out];
                }
                cnt--;
                out++;
            } else if (input[in] == output[out]) {
                in++;
                out++;
            }
        }

        sb.append(max + "\n" + a + " " + b);
        System.out.println(sb);
    }
}
