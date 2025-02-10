package algorithm.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D2_14510 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());

            int max = 0;

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                max = Math.max(arr[i], max);
            }

            int answer = getAnswer(n, max, arr);

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static int getAnswer(int n, int max, int[] arr) {
        int odd = 0, even = 0;
        for (int i = 0; i < n; i++) {
            int sub = max - arr[i];

            if (sub == 0) {
                continue;
            }
            even += sub / 2;
            odd += sub % 2;
        }


        if (even > odd) {
            while (Math.abs(even - odd) > 1) {
                even--;
                odd += 2;
            }
        }

        int answer = 0;

        if (odd > even) {
            answer = odd * 2 - 1;
        } else if (even > odd) {
            answer = even * 2;
        } else {
            answer = odd + even;
        }
        return answer;
    }
}
