import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> right = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (right.size() == left.size()) {
                left.add(num);
            } else {
                right.add(num);
            }

            if (!right.isEmpty() && !left.isEmpty()) {
                if (right.peek() < left.peek()) {
                    int temp = right.poll();
                    right.add(left.poll());
                    left.add(temp);
                }
            }

            sb.append(left.peek()).append("\n");
        }

        System.out.println(sb);
    }
}
