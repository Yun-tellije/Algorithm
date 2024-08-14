package algorithm.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S4_1065 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(bf.readLine());
        int sum = 0;

        if (n < 100) {
            sum = n;
        } else if (n < 111){
            sum = 99;
        } else {
            sum = 99;

            for (int i = 111; i <= n; i++) {
                int a = i % 10;
                int b = (i / 10) % 10;
                int c = i / 100;

                if ((a - b) == (b - c)) {
                    sum++;
                }
            }
        }

        sb.append(sum);
        System.out.println(sb);
    }
}
