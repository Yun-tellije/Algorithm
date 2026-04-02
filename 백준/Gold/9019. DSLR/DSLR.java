import java.io.*;
import java.util.*;

/**
 * 1. DSLR 명령어에 맞게 이동
 * 2. 해당 지점 방문 여부 체크 및 명령어 저장
 * 3. 목표 숫자에 도달 시 return, 해당 지점 명령어 출력
 */
public class Main {

    // 0 ~ 9999 까지의 방문 여부 점검 및 해당 숫자를 도달했던 명령어 저장
    static boolean[] visit;
    static String[] cmd;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            visit = new boolean[10000];
            cmd = new String[10000];
            bfs(a, b);

            sb.append(cmd[b]).append("\n");
        }

        System.out.println(sb);
    }

    /**
     * D: n * 2
     * S: n - 1(n이 0일 경우 9999)
     * L: n 왼쪽으로 회전
     * R: n 오른쪽으로 회전
     */
    static void bfs(int a, int b) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(a);
        visit[a] = true;
        cmd[a] = "";

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == b) return;

            int D = cur * 2 % 10000;
            int S = cur == 0 ? 9999 : cur - 1;
            int L = cur / 1000 + (cur % 1000) * 10;
            int R = cur / 10 + (cur % 10) * 1000;

            // 현재 위치에서 D 명령어를 적용한 지점이 방문하지 않았을 경우 이동
            if (!visit[D]) {
                visit[D] = true;
                cmd[D] = cmd[cur] + "D";
                q.add(D);
            }

            // 현재 위치에서 S 명령어를 적용한 지점이 방문하지 않았을 경우 이동
            if (!visit[S]) {
                visit[S] = true;
                cmd[S] = cmd[cur] + "S";
                q.add(S);
            }

            // 현재 위치에서 L 명령어를 적용한 지점이 방문하지 않았을 경우 이동
            if (!visit[L]) {
                visit[L] = true;
                cmd[L] = cmd[cur] + "L";
                q.add(L);
            }

            // 현재 위치에서 R 명령어를 적용한 지점이 방문하지 않았을 경우 이동
            if (!visit[R]) {
                visit[R] = true;
                cmd[R] = cmd[cur] + "R";
                q.add(R);
            }
        }

    }
}
