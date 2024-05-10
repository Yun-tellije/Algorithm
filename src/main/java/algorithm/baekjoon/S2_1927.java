package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class S2_1927 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> arr = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int t = Integer.parseInt(br.readLine());
            if (t == 0) {
                if (arr.isEmpty()) {
                    sb.append(0).append("\n");
                }
                else {
                    sb.append(arr.remove()).append("\n");
                }
            } else {
                arr.add(t);
            }
        }

        System.out.println(sb);
    }
}