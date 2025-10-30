import java.io.*;
import java.util.*;

class Solution {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int X, Y;
    static boolean[][][] visit;
    static char[][] arr;

    public int solution(String[] board) {
        int answer = 0;
        X = board.length;
        Y = board[0].length();
        arr = new char[X][Y];
        visit = new boolean[4][X][Y];

        int startX = 0, startY = 0;
        
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                arr[i][j] = board[i].charAt(j);
                
                if (arr[i][j] == 'R') {
                    startX = i;
                    startY = j;
                }
            }
        }
        
        answer = bfs(startX, startY);

        return answer;
    }

    static int bfs(int startX, int startY) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {startX, startY, 0});

        while (!q.isEmpty()) {
            int x = q.peek()[0];
            int y = q.peek()[1];
            int count = q.peek()[2];
            q.poll();

            for (int i = 0; i < 4; i++) {
                int[] result = dfs(x, y, i);
                
                if (result.length == 1) continue;
                
                int cx = result[0];
                int cy = result[1];
                
                if (arr[cx][cy] == 'G') return count + 1;
                
                q.add(new int[] {cx, cy, count + 1});
            }
        }
        
        return -1;
    }

    static int[] dfs(int x, int y, int d) {
        int cx = x + dx[d];
        int cy = y + dy[d];

        if (!isIn(cx, cy) || arr[cx][cy] == 'D') {
            if (visit[d][x][y]) {
                return new int[] {-1};
            }
            visit[d][x][y] = true;
            return new int[] {x, y};
        }
        
        return dfs(cx, cy, d);
    }

    static boolean isIn(int x, int y) {
        return x >= 0 && x < X && y >= 0 && y < Y;
    }
}