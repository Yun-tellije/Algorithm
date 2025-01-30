package algorithm.bfs;

import java.io.*;
import java.util.*;

class G4_12851 {

    static int count = 0;
    static int min = Integer.MAX_VALUE;
    static int[] time = new int[100001];
    static int n;
    static int k;

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (n == k) {
            sb.append(0).append("\n").append(1);
        } else {
            bfs();
            sb.append(min).append("\n").append(count);
        }

        System.out.print(sb);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        time[n]++;
        q.add(n);

        while (!q.isEmpty()) {
            int x = q.poll();

            if (time[x] > min) {
                continue;
            }

            for (int i = 0; i < 3; i++) {
                int next;
                if (i == 0) {
                    next = x + 1;
                } else if (i == 1) {
                    next = x - 1;
                } else {
                    next = x * 2;
                }

                if (next < 0 || next > 100000) {
                    continue;
                }

                if (next == k) {
                    min = time[x];
                    count++;
                }

                if (time[next] == 0 || time[next] == time[x] + 1) {
                    q.add(next);
                    time[next] = time[x] + 1;
                }
            }
        }
    }
}