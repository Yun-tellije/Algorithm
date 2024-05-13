package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class S4_1620 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<Integer, String> num = new HashMap<>();
        HashMap<String, Integer> name = new HashMap<>();


        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            num.put(i + 1, s);
            name.put(s, i + 1);
        }

        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            try {
                int a = Integer.parseInt(s);
                sb.append(num.get(a)).append("\n");
            } catch (NumberFormatException e) {
                sb.append(name.get(s)).append("\n");
            }
        }

        System.out.println(sb);
    }
}