import java.io.*;
import java.util.*;

/**
 * (0, 0) -> (n - 1, m - 1) 좌표까지 도달할 수 있는 경우의 수
 *
 * 조건
 * 1. 상하좌우로만 이동
 * 2. 현재 지점보다 낮은 지점으로 이동
 *
 * 위 방식으로만 풀면 시간초과 발생
 *
 * +
 * 이미 탐색된 경로가 몇개인지 저장 후 해당 값 반환
 */
public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[][] arr, dp;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0, 0));
    }

    static int dfs(int x, int y) {
        if (x == n - 1 && y == m - 1) {
            return 1;
        }

        if (dp[x][y] != -1) return dp[x][y];

        dp[x][y] = 0;

        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if (!isIn(cx, cy) || arr[x][y] <= arr[cx][cy]) continue;

            dp[x][y] += dfs(cx, cy);
        }

        return dp[x][y];
    }

    static boolean isIn(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}
