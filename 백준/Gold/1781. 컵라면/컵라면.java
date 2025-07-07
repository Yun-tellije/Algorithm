import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Ramen> problem = new PriorityQueue<>((o1, o2) -> o1.deadline - o2.deadline);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int deadline = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());

            problem.add(new Ramen(deadline, count));
        }

        PriorityQueue<Integer> min = new PriorityQueue<>();

        while (!problem.isEmpty()) {
            Ramen ramen = problem.poll();
            min.add(ramen.count);

            if (min.size() > ramen.deadline) min.poll();
        }

        long answer = 0;
        while (!min.isEmpty()) {
            answer += min.poll();
        }

        System.out.println(answer);
    }

    static class Ramen {
        int deadline;
        int count;

        Ramen(int deadline, int count) {
            this.deadline = deadline;
            this.count = count;
        }
    }
}
