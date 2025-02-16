package algorithm.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SW_TEST_1767 {

    static int n;
    static int[][] arr;
    static List<int[]> list;
    static boolean[][] visit;
    static int answer, coreCount;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            visit = new boolean[n][n];
            answer = Integer.MAX_VALUE;
            list = new ArrayList<>();
            coreCount = 0;

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if (arr[i][j] == 1 && (i != 0 && i != n - 1 && j != 0 && j != n - 1)) {
                        list.add(new int[] {i, j});
                    }
                }
            }

            findCore(0, 0, 0);
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    /**
     * 1. 프로세서 찾기
     */
    static void findCore(int depth, int core, int wire) {
        if (depth == list.size()) {
           checkCore(core, wire);
            return;
        }

        int x = list.get(depth)[0];
        int y = list.get(depth)[1];

        for (int i = 0; i < 4; i++) {
            int count = check(x, y, i);
            if (count != 0) {
                for (int j = 0; j < count; j++) {
                    int cx = x + dx[i] * (j + 1);
                    int cy = y + dy[i] * (j + 1);

                    arr[cx][cy] = 1;
                }
                findCore(depth + 1, core + 1, wire + count);

                for (int j = 0; j < count; j++) {
                    int cx = x + dx[i] * (j + 1);
                    int cy = y + dy[i] * (j + 1);

                    arr[cx][cy] = 0;
                }
            } else {
                findCore(depth + 1, core, wire);
            }
        }
    }

    /**
     * 2. 연결하려는 방향에 장애물(전선, 프로세서) 있는지 확인
     */
    static int check(int x, int y, int d) {
        int idx = 0;

        while (true) {
            int cx = x + dx[d] * (idx + 1);
            int cy = y + dy[d] * (idx + 1);

            if (cx < 0 || cx >= n || cy < 0 || cy >= n) {
                break;
            }

            if (visit[cx][cy] || arr[cx][cy] == 1) {
                return 0;
            }
            idx++;
        }
        return idx;
    }

    /**
     * 3. 전선, 전원 연결된 프로세서 수 구하기
     */
    static void checkCore(int core, int wire) {
        if (core > coreCount) {
            coreCount = core;
            answer = wire;
        } else if (core == coreCount) {
            answer = Math.min(answer, wire);
        }
    }
}
