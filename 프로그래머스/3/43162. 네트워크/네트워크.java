import java.util.*;

class Solution {
    
    static ArrayList<Integer>[] list;
    static boolean[] visit;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
    
        visit = new boolean[n];
        list = new ArrayList[n];
        
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || computers[i][j] == 0) continue;
                
                list[i].add(j);
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (visit[i]) continue;
            
            visit[i] = true;
            dfs(i);
            answer++;
        }
        
        return answer;
    }
    
    static void dfs(int next) {
        for (int i : list[next]) {
            if (visit[i]) continue;
            
            visit[i] = true;
            dfs(i);
        }
    }
}