package algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B3_10162 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(bf.readLine());
        int a, b, c;
        if (T % 10 == 0) {
            a =  T / 300;
            b = (T % 300) / 60;
            c = (T % 60)  / 10;

            sb.append(a).append(" ").append(b).append(" ").append(c);
        } else {
            sb.append(-1);
        }

        System.out.println(sb);
    }
}
