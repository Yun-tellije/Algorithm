package algorithm.graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_13549 {

    static int n;
    static int k;
    static int min = Integer.MAX_VALUE;
    static int max = 100000;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visit = new boolean[max + 1];

        dijkstra();
        System.out.println(min);
    }

    static void dijkstra() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(n, 0));

        while (!q.isEmpty()) {
            Node node = q.poll();
            int x = node.x;
            int time = node.time;
            visit[x] = true;

            if (x == k) {
                min = Math.min(min, time);
            }

            if (x * 2 <= max && !visit[x * 2]) {
                q.offer(new Node(x * 2, time));
            }
            if (x + 1 <= max && !visit[x + 1]) {
                q.offer(new Node(x + 1, time + 1));
            }
            if (x - 1 >= 0 && !visit[x - 1]) {
                q.offer(new Node(x - 1, time + 1));
            }
        }
    }

    static class Node {
        int x;
        int time;

        Node (int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
}
