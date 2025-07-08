import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {-1, 0 ,1 ,0};
    static int[] dy = {0, 1, 0, -1};

    static boolean[][] visit;
    static int n, m, answer;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visit = new boolean[n][m];
        arr = new int[n][m];
        answer = 0;

        st = new  StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        int startD = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(startX, startY, startD);

        System.out.println(answer);
    }

    static void bfs(int startX, int startY, int startD) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {startX, startY, startD});

        while (!q.isEmpty()) {
            int x = q.peek()[0];
            int y = q.peek()[1];
            int d = q.peek()[2];
            q.poll();

            // 현재 칸 청소 안했을 경우 청소
            if (!visit[x][y]) {
                answer++;
                visit[x][y] = true;
            }

            // 현재 칸 주변 4칸 중 청소되지 않은 빈 칸 조회
            boolean check = false;
            for (int i = 0; i < 4; i++) {
                int cx =  x + dx[i];
                int cy =  y + dy[i];

                // 청소되지 않은 칸 존재했다면 break
                if (isIn(cx, cy) && arr[cx][cy] == 0 && !visit[cx][cy]) {
                    check = true;
                    break;
                }
            }

            if (check) {
                // 반시계 회전 후 해당 방향으로 한 칸 전진
                int nextD = d == 0 ? 3 : d - 1;
                int nextX = x + dx[nextD];
                int nextY = y + dy[nextD];

                // 빈 칸이고 청소 안 했으면 해당 칸으로 이동
                if (arr[nextX][nextY] == 0 && !visit[nextX][nextY]) {
                    q.add(new int[] {nextX, nextY, nextD});
                } else {
                    q.add(new int[] {x, y, nextD});
                }
                continue;
            }
            
            // 청소되지 않은 빈 칸이 없는 경우 후진
            int nextX = x - dx[d];
            int nextY = y - dy[d];

            // 후진을 할 수 없다면 종료
            if (!isIn(nextX, nextY) || arr[nextX][nextY] == 1) break;

            q.add(new int[] {nextX, nextY, d});
        }
    }

    static boolean isIn(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}