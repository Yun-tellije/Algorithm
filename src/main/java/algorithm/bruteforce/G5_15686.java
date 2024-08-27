package algorithm.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G5_15686 {

    static int[][] arr;
    static int min = 10000;
    static ArrayList<int[]> person = new ArrayList<>();
    static ArrayList<int[]> chicken = new ArrayList<>();
    static boolean[] open;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());

            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] == 1) {
                    person.add(new int[] {i, j});
                }
                if (arr[i][j] == 2) {
                    chicken.add(new int[] {i, j});
                }
            }
        }

        open = new boolean[chicken.size()];
        dfs(0, 0);

        sb.append(min);
        System.out.println(sb);
    }

    static void dfs(int start, int index) {
        if (index == m) {
            int r = 0;

            for (int i = 0; i < person.size(); i++) {
                int temp = 1000;

                for (int j = 0; j < chicken.size(); j++) {
                    if (open[j]) {
                        int d = Math.abs(person.get(i)[0] -chicken.get(j)[0]) + Math.abs(person.get(i)[1] -chicken.get(j)[1]);
                        temp = Math.min(temp, d);
                    }
                }
                r += temp;
            }

            min = Math.min(min, r);
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            if (!open[i]) {
                open[i] = true;
                dfs(i + 1, index + 1);
                open[i] = false;
            }
        }
    }
}
