package algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class G3_1939 {

    static int n;
    static int start;
    static int end;
    static boolean[] visit;
    static ArrayList<Node> list[];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        int left = 0;
        int right = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
            right = Math.max(c, right);
        }

        st = new StringTokenizer(bf.readLine());

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        while (left <= right) {
            int mid = (left + right) / 2;
            visit = new boolean[n + 1];

            if (bfs(start, end, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(right);
    }

    static boolean bfs(int start, int end, int mid) {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int t = queue.poll();

            if (t == end) {
                return true;
            }

            for (int i = 0; i < list[t].size(); i++) {
                if (list[t].get(i).cost >= mid && !visit[list[t].get(i).n]) {
                    visit[list[t].get(i).n] = true;
                    queue.offer(list[t].get(i).n);
                }
            }
        }
        return false;
    }

    static class Node{
        int n;
        int cost;

        Node(int n, int cost) {
            this.n = n;
            this.cost = cost;
        }
    }
}
