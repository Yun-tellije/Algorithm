package algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class G4_1715 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(bf.readLine());
        Queue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            queue.add(Integer.parseInt(bf.readLine()));
        }

        int sum = 0;

        while (queue.size() > 1) {
            int a = queue.poll() + queue.poll();
            sum += a;
            queue.add(a);
        }

        sb.append(sum);

        System.out.println(sb);
    }
}
