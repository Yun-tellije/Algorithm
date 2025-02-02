package algorithm.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class G4_1967 {

    static class Node {
        int self;
        int cost;

        Node (int self, int cost) {
            this.self = self;
            this.cost = cost;
        }
    }

    static int n;
    static List<Node>[] tree;
    static boolean[] visit;
    static int max = 0;
    static int findNode = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());

        if (n == 1) {
            System.out.println(0);
            return;
        }

        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            tree[parent].add(new Node(child, cost));
            tree[child].add(new Node(parent, cost));
        }

        visit = new boolean[n + 1];
        dfs(1, 0);

        visit = new boolean[n + 1];
        dfs(findNode, 0);

        System.out.println(max);
    }

    static void dfs(int node, int sum) {
        if (sum > max) {
            max = sum;
            findNode = node;
        }

        visit[node] = true;

        for (Node next : tree[node]) {
            if (!visit[next.self]) {
                dfs(next.self, sum + next.cost);
            }
        }
    }
}
