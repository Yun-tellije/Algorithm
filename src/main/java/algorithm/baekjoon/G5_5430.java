package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class G5_5430 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            String s = br.readLine();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");

            ArrayDeque<Integer> dq = new ArrayDeque<>();
            while (st.hasMoreTokens()) {
                dq.add(Integer.parseInt(st.nextToken()));
            }

            AC(s, dq);
        }

        System.out.println(sb);
    }

    static void AC(String s, ArrayDeque<Integer> dq) {
        boolean isReverse = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == 'R') { // 뒤집기
                isReverse = !isReverse;
            }
            else if (c == 'D') { // 앞에 수 버리기
                if (dq.isEmpty()) {
                    sb.append("error\n");
                    return;
                }
                if (isReverse) {
                    dq.pollLast();
                } else {
                    dq.pollFirst();
                }
            }
        }

        sb.append("[");

        while (!dq.isEmpty()) {
            if (isReverse) {
                sb.append(dq.pollLast());
            } else {
                sb.append(dq.pollFirst());
            }
            if (!dq.isEmpty()) {
                sb.append(",");
            }
        }
        sb.append("]\n");
    }
}

