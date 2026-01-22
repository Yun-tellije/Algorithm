import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int n;
    static boolean[][] apple;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        apple = new boolean[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            apple[a - 1][b - 1] = true;
        }

        int l = Integer.parseInt(br.readLine());
        Queue<String[]> cmd = new ArrayDeque<>();

        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cmd.add(new String[]{st.nextToken(), st.nextToken()});
        }

        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{0, 0});
        visit[0][0] = true;

        int dir = 1;
        int time = 0;

        while (true) {
            time++;

            int[] head = dq.peekFirst();
            int nx = head[0] + dx[dir];
            int ny = head[1] + dy[dir];

            if (isEnd(nx, ny)) {
                System.out.println(time);
                return;
            }

            dq.addFirst(new int[]{nx, ny});
            visit[nx][ny] = true;

            if (apple[nx][ny]) {
                apple[nx][ny] = false;
            } else {
                int[] temp = dq.removeLast();
                visit[temp[0]][temp[1]] = false;
            }

            if (cmd.isEmpty() || Integer.parseInt(cmd.peek()[0]) != time) continue;

            String[] moveCmd = cmd.poll();
            if (moveCmd[1].equals("L")) {
                dir = (dir + 3) % 4;
            } else {
                dir = (dir + 1) % 4;
            }
        }
    }

    static boolean isEnd(int x, int y) {
        return x >= n || x < 0 || y >= n || y < 0 || visit[x][y];
    }
}
