package algorithm.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_TEST_5656 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int n, w, h;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            answer = Integer.MAX_VALUE;

            int[][] arr = new int[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j ++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dfs(0, arr);

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }

        System.out.println(sb);
    }


    static void dfs(int depth, int[][] arr) {
        if (depth == n) {
            int sum = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (arr[i][j] > 0) {
                        sum++;
                    }
                }
            }


            answer = Math.min(answer, sum);
            return;
        }

        for (int i = 0; i < w; i++) {
            dfs(depth + 1, shoot(i, arr));
        }
    }

    static int[][] shoot(int tx, int[][] arr) {
        Queue<int[]> q = new LinkedList<>();

        // 위에서부터 처음 만나는 벽돌 추가
        for (int i = 0; i < h; i++) {
            if (arr[i][tx] != 0) {
                q.add(new int[] {i, tx});
                break;
            }
        }

        int[][] temp = new int[h][w];

        // 배열 변경을 위한 복사
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                temp[i][j] = arr[i][j];
            }
        }

        boolean[][] visit = new boolean[h][w];

        while(!q.isEmpty()) {
            int x = q.peek()[0];
            int y = q.peek()[1];
            q.poll();

            // 해당 크기만큼 부셔야하므로 원본 배열의 count 체크
            int count = arr[x][y];
            if (count == 1) {
                temp[x][y] = 0;
                continue;
            }

            temp[x][y] = 0;
            for (int i = 1; i < count; i++) {
                for (int d = 0; d < 4; d++) {
                    // 2칸 이상이라면 이동해야함
                    int cx = x + (dx[d] * i);
                    int cy = y + (dy[d] * i);

                    // 범위 확인 및 방문 확인
                    if (cx < 0 || cx >= h || cy < 0 || cy >= w || visit[cx][cy] || arr[cx][cy] == 0) {
                        continue;
                    }

                    visit[cx][cy] = true;
                    temp[cx][cy] = 0;
                    q.add(new int[] {cx, cy});
                }
            }
        }

        /**
         * 빈 곳이라면 아래로 내려감
         */
        int[][] after = new int[h][w];

        for (int i = 0; i < w; i++) {
            int idx = h - 1;
            for (int j = h - 1; j >= 0; j--) {
                if (temp[j][i] > 0) {
                    after[idx][i] = temp[j][i];
                    idx--;
                }
            }
        }

        return after;
    }

}