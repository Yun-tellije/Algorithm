package algorithm.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Prim {
    static class Node implements Comparable<Node> {
        int v;
        int w;

        Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }

    static List<List<Node>> graph = new ArrayList<>();
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visit = new boolean[n + 1];
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v, weight));
            graph.get(v).add(new Node(u, weight));
        }

        System.out.println(prim(1));
    }

    static int prim(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        int sum = 0;
        int count = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int v = cur.v;
            int w = cur.w;

            if (visit[v]) continue;

            visit[v] = true;
            sum += w;
            count++;

            for (Node n : graph.get(v)) {
                if (!visit[n.v]) pq.add(n);
            }

            if (count == visit.length - 1) break;
        }

        return sum;
    }
}
