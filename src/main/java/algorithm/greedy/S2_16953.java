package algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_16953 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int i = 1;
        while (a < b) {
            if (b % 2 == 0) {
                b /= 2;
                i++;
            } else if (b % 10 == 1) {
                b /= 10;
                i++;
            } else {
                break;
            }
        }

        if (a == b) {
            sb.append(i);
        } else {
            sb.append(-1);
        }

        System.out.println(sb);
    }
}
