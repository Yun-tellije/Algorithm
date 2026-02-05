import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int[] temp = new int[2];
        temp[0] = scores[0][0];
        temp[1] = scores[0][1];
        
        Arrays.sort(scores, (a, b) -> {
            if (a[0] == b[0]) {
                    return a[1] - b[1];
            }
            return b[0] - a[0];
        });
        
        int rank = 1;
        int max = 0;
        int sum = temp[0] + temp[1];
        
        for (int i = 0; i < scores.length; i++) {
            if (scores[i][1] < max) {
                if (scores[i][0] == temp[0] && scores[i][1] == temp[1]) return -1;
                continue;
            }
            
            max = Math.max(max, scores[i][1]);
            
            if (scores[i][0] + scores[i][1] > sum) {
                rank++;
            }
        }
        
        return rank;
    }
}