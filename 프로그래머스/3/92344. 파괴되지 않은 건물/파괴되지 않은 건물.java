import java.util.*;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        
        
        int[][] diff = new int[n + 1][m + 1];
        
        for (int i = 0; i < skill.length; i++) {
            int type = skill[i][0];
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            int degree = type == 1 ? skill[i][5] * -1 : skill[i][5];
            
            diff[r1][c1] += degree;
            diff[r1][c2 + 1] -= degree;
            diff[r2 + 1][c1] -= degree;
            diff[r2 + 1][c2 + 1] += degree;
        }
        
        for (int i = 0; i < n; i++) {
             for (int j = 1; j < m; j++) {
                diff[i][j] += diff[i][j - 1];
            } 
        }
        
        for (int j = 0 ; j < m; j++) {
            for (int i = 1; i < n; i++) {
                diff[i][j] += diff[i - 1][j];
            }
        }
    
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] + diff[i][j] > 0) answer++;
            }
        }
        
        return answer;
    }
}