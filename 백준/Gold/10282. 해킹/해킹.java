import java.io.*;
import java.util.*;

public class Main {

    static final int INF = Integer.MAX_VALUE;

    static List<Computer>[] list;
    static int[] dist;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int T = 0; T < t; T++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list = new ArrayList[n + 1];
            dist = new int[n + 1];
            visit = new boolean[n + 1];

            for (int i = 1; i <= n; i++) {
                list[i] = new ArrayList<>();
            }
            Arrays.fill(dist, INF);

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                list[b].add(new Computer(a, s));
            }

            dijkstra(c);

            int count = 0;
            int totalTime = 0;

            for (int i = 1; i <= n; i++) {
                if (dist[i] != INF) {
                    count++;
                    totalTime = Math.max(totalTime, dist[i]);
                }
            }

            sb.append(count).append(" ").append(totalTime).append("\n");
        }

        System.out.println(sb);
    }

    static void dijkstra(int start) {
        PriorityQueue<Computer> pq = new PriorityQueue<>();

        dist[start] = 0;
        pq.offer(new Computer(start, 0));

        while(!pq.isEmpty()) {
            Computer cur = pq.poll();

            if (!visit[cur.depend]) {
                visit[cur.depend] = true;

                for (Computer next : list[cur.depend]) {
                    if (dist[next.depend] > dist[cur.depend] + next.time) {
                        dist[next.depend] = dist[cur.depend] + next.time;
                        pq.add(new Computer(next.depend, dist[next.depend]));
                    }
                }
            }
        }
    }

    static class Computer implements Comparable<Computer> {
        int depend;
        int time;

        public Computer(int depend, int time) {
            this.depend = depend;
            this.time = time;
        }

        @Override
        public int compareTo(Computer o) {
            return this.time - o.time;
        }
    }
}
