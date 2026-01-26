import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static char[][] arr;
    static int answer;
    static int[] select;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new char[5][5];
        select = new int[7];

        for (int i = 0; i < 5; i++) {
            String s = br.readLine();

            for (int j = 0; j < 5; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        dfs(0, 0);

        System.out.println(answer);
    }

    static void dfs(int depth, int start) {
        if (depth == 7) {
            if (check()) answer++;
            return;
        }

        for (int i = start; i < 25; i++) {
            select[depth] = i;
            dfs(depth + 1, i + 1);
        }
    }

    static boolean check() {
        boolean[][] visit = new boolean[5][5];
        int cnt = 0;

        for (int i = 0; i < 7; i++) {
            int x = select[i] / 5;
            int y = select[i] % 5;

            visit[x][y] = true;
            if (arr[x][y] == 'S') cnt++;
        }

        if (cnt < 4) return false;

        return bfs(visit);
    }

    static boolean bfs(boolean[][] check) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visit = new boolean[5][5];

        int startX = select[0] / 5;
        int startY = select[0] % 5;

        q.add(new int[] {startX, startY});
        visit[startX][startY] = true;

        int cnt = 1;

        while (!q.isEmpty()) {
            int x = q.peek()[0];
            int y = q.peek()[1];
            q.poll();

            for (int i = 0; i < 4; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];

                if (!isIn(cx, cy) || !check[cx][cy] || visit[cx][cy]) continue;

                q.add(new int[]{cx, cy});
                visit[cx][cy] = true;
                cnt++;
            }
        }

        return cnt == 7;
    }

    static boolean isIn(int x, int y) {
        return x >= 0 && x < 5 && y >= 0 && y < 5;
    }
}
