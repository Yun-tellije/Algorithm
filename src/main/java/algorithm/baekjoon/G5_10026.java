package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G5_10026 {

    static char[][] arr1;
    static char[][] arr2;
    static boolean[][] visit1;
    static boolean[][] visit2;
    static int n;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        arr1 = new char[n][n];
        arr2 = new char[n][n];
        visit1 = new boolean[n][n];
        visit2 = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                char c = s.charAt(j);
                arr1[i][j] = c;
                if (c == 'G')
                    arr2[i][j] = 'R';
                else
                    arr2[i][j] = c;
            }
        }

        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0 ; j < n; j++) {
                if (!visit1[i][j]) {
                    dfs(1, i, j);
                    count1++;
                }
                if (!visit2[i][j]) {
                    dfs(2, i, j);
                    count2++;
                }
            }
        }
        sb.append(count1).append(" ").append(count2);

        System.out.println(sb);
    }

    static void dfs(int idx, int x, int y) {
        if (idx == 1) {
            visit1[x][y] = true;
        }
        else if (idx == 2){
            visit2[x][y] = true;
        }

        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if (cx >= 0 && cx < n && cy >= 0 && cy < n) {
                if (idx == 1) {
                    if (arr1[x][y] == arr1[cx][cy] && !visit1[cx][cy]) {
                        dfs(1, cx, cy);
                    }
                }
                else if (idx == 2) {
                    if (arr2[x][y] == arr2[cx][cy] && !visit2[cx][cy]) {
                        dfs(2, cx, cy);
                    }
                }
            }
        }
    }
}