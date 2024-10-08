package algorithm.graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class G4_1261 {

    static int n;
    static int m;
    static int[][] arr;
    static int[][] dist;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = bf.readLine();

            for (int j = 0; j < m; j++) {
                arr[i][j] = Character.getNumericValue(s.charAt(j));
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        dijkstra();

        System.out.println(dist[n - 1][m - 1]);
    }

    static void dijkstra() {
        Queue<point> queue = new PriorityQueue<>();
        queue.offer(new point(0, 0, 0));
        dist[0][0] = 0;

        while (!queue.isEmpty()) {
            point p = queue.poll();

            if (p.x == (n - 1) && p.y == (m - 1)) {
                answer = p.cost;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int cx = p.x + dx[i];
                int cy = p.y + dy[i];
                int cost = p.cost;

                if (cx >= 0 && cx < n && cy >= 0 && cy < m) {
                    if (arr[cx][cy] == 1) {
                        cost++;
                    }
                    if (dist[cx][cy] > cost) {
                        dist[cx][cy] = cost;
                        queue.offer(new point(cx, cy, cost));
                    }
                }
            }
        }
    }

    static class point implements Comparable<point> {
        int x;
        int y;
        int cost;

        point (int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(point p) {
            return this.cost - p.cost;
        }
    }
}
