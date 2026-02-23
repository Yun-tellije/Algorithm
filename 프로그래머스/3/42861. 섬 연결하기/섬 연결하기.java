import java.util.*;

class Solution {
    
    static int[] parents;
    
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        int answer = 0;
        int count = 0;
        
        for (int[] cost : costs) {
            int a = cost[0];
            int b = cost[1];
            int c = cost[2];
            
            if (union(a, b)) {
                answer += c;
                count++;
            }
            
            if (count == n - 1) break;
        }
        
        return answer;
    }
    
    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if (a == b) return false;
        
        parents[b] = a;
        return true;
    }
    
    static int find(int a) {
        if (a == parents[a]) return a;
        
        return parents[a] = find(parents[a]);
    }
}