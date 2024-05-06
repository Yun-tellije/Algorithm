package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class S4_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        HashSet<String> hashSet = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<String> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            hashSet.add(s);
        }

        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            if (hashSet.contains(s)) {
                answer.add(s);
            }
        }

        Collections.sort(answer);
        sb.append(answer.size()).append("\n");
        for (int i = 0; i < answer.size(); i++) {
            sb.append(answer.get(i)).append("\n");
        }

        System.out.println(sb);
    }
}