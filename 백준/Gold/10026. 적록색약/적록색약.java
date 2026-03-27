import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static StringBuilder sb;
    static int n;
    static char[][] arr1, arr2;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        arr1 = new char[n][n];
        arr2 = new char[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            for (int j = 0; j < n; j++) {
                char c = s.charAt(j);
                arr1[i][j] = c;
                arr2[i][j] = c == 'G' ? 'R' : c;
            }
        }

        sb.append(check(arr1)).append(" ").append(check(arr2));
        System.out.println(sb);
    }

    static int check(char[][] arr) {
        int count = 0;
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visit[i][j]) continue;

                bfs(i, j, arr);
                count++;
            }
        }

        return count;
    }

    static void bfs(int startX, int startY, char[][] arr) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {startX, startY});
        visit[0][0] = true;

        while (!q.isEmpty()) {
            int x = q.peek()[0];
            int y = q.peek()[1];
            q.poll();

            for (int i = 0; i < 4; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];

                if (!isIn(cx, cy) || visit[cx][cy] || arr[x][y] != arr[cx][cy]) continue;

                visit[cx][cy] = true;
                q.add(new int[] {cx, cy});
            }
        }
    }

    static boolean isIn(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
