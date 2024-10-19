package algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1_21314 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = bf.readLine();

        sb.append(getMax(s) + "\n");
        sb.append(getMin(s));
        System.out.println(sb);
    }

    static String getMax(String s) {
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'M') {
                int k = i;

                while (k < s.length() && s.charAt(k) == 'M') {
                    k++;
                }

                if (k == s.length()) {
                    for (int j = i; j < k; j++) {
                        sb.append(1);
                    }
                } else {
                    sb.append(5);
                    for (int j = i; j < k; j++) {
                        sb.append(0);
                    }
                }
                i = k;
            } else {
                sb.append(5);
            }
        }
        return sb.toString();
    }

    static String getMin(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == 'M') {
                int k = i;

                while (k < s.length() && s.charAt(k) == 'M') {
                    k++;
                }
                sb.append(1);
                for (int j = i; j < k - 1; j++) {
                    sb.append(0);
                }

                i = k - 1;

            } else {
                sb.append(5);
            }
        }

        return sb.toString();
    }
}
