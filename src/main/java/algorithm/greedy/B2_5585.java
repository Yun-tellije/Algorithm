package algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2_5585 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = 1000 - Integer.parseInt(br.readLine());
        int cnt = 0;

        while (n > 0) {
            int x;

            if (n >= 500) {
                x = 500;
            } else if (n >= 100) {
                x = 100;
            } else if (n >= 50) {
                x = 50;
            } else if (n >= 10) {
                x = 10;
            } else if (n >= 5) {
                x = 5;
            } else {
                x = 1;
            }
            cnt += n / x;
            n %= x;
        }

        sb.append(cnt);
        System.out.println(sb);
    }
}
