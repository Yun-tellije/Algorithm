package algorithm.graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_1446 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());

            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] distance = new int[d + 1];

        for (int i = 0; i <= d; i++) {
            distance[i] = i;
        }

        for (int i = 1; i <= d; i++) {
            distance[i] = Math.min(distance[i], distance[i - 1] + 1);
            for (int j = 0; j < n; j++) {
                if (arr[j][1] == i) {
                    distance[i] = Math.min(distance[i], distance[arr[j][0]] + arr[j][2]);
                }
            }
        }

        System.out.println(distance[d]);
    }
}
