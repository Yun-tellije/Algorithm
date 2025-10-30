import java.io.*;
import java.util.*;

class Solution {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static char[][] arr;
    static int X, Y;

    public int solution(String[] maps) {
        int answer = 0;
        X = maps.length;
        Y = maps[0].length();
        arr = new char[X][Y];

        int startX = 0, startY = 0;
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                arr[i][j] = maps[i].charAt(j);

                if (arr[i][j] == 'S') {
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
        q.add(new int[] {startX, startY, 0, 0});
        boolean[][][] visit = new boolean[2][X][Y];
        visit[0][startX][startY] = true;
        
        while (!q.isEmpty()) {
            int x = q.peek()[0];
            int y = q.peek()[1];
            int check = q.peek()[2];
            int count = q.peek()[3];
            q.poll();
            
            if (check == 1 && arr[x][y] == 'E') return count;
            
            for (int i = 0; i < 4; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];
                
                if (!isIn(cx, cy) || visit[check][cx][cy] || arr[cx][cy] == 'X') continue;
                
                visit[check][cx][cy] = true;
                if (check == 0 && arr[cx][cy] == 'L') {
                    q.add(new int[] {cx, cy, 1, count + 1});
                    visit[1][cx][cy] = true;
                    continue;
                }
                q.add(new int[] {cx, cy, check, count + 1});
            }
        }
        
        return -1;
    }
    
    static boolean isIn(int x, int y) {
        return x >= 0 && x < X && y >= 0 && y < Y;
    }
}