package algorithm.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G5_12919 {

    static String s;
    static String t;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        s = bf.readLine();
        t = bf.readLine();

        dfs(s, t);

        System.out.println(answer);
    }

    static void dfs(String s, String t) {
        if (t.length() == s.length()) {
            if (t.equals(s))
                answer = 1;
            return;
        }

        if (answer == 1)
            return;

        if (t.charAt(0) == 'B') {
            String sub = t.substring(1);
            StringBuilder sb = new StringBuilder(sub);
            dfs(s, sb.reverse().toString());
        }

        if (t.charAt(t.length() - 1) == 'A') {
            dfs(s, t.substring(0, t.length() -1));
        }
    }
}
