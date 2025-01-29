package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class S3_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(bf.readLine());

        for (int T = 0; T < tc; T++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int n = Integer.parseInt(st.nextToken()); // 문서 개수
            int m = Integer.parseInt(st.nextToken()); // 몇번째로 인쇄되는지 확인할 문서가 Queue의 몇번째 인지 나타내는 정수

            LinkedList<int[]> q = new LinkedList<>();
            st = new StringTokenizer(bf.readLine());

            for (int i = 0; i < n; i++) {
                q.add(new int[] {i, Integer.parseInt(st.nextToken())});
            }

            int count = 0;
            while (!q.isEmpty()) {
                int idx = q.peek()[0];
                int value = q.peek()[1];
                boolean isMax = true;
                q.poll();

                for (int i = 0; i < q.size(); i++) {
                    if (value < q.get(i)[1]) {
                        q.add(new int[] {idx, value});

                        for (int j = 0; j < i; j++) {
                            q.add(q.poll());
                        }

                        isMax = false;
                        break;
                    }
                }

                if (!isMax) {
                    continue;
                }

                count++;
                if (idx == m) {
                    break;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
