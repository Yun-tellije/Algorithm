import java.util.*;

class Solution {
    
    static boolean[] visit;
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        ArrayList<Integer>[] list = new ArrayList[n + 1];
        ArrayList<Integer>[] reverse = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
            reverse[i] = new ArrayList<>();
        }
        
        for (int[] r : results) {
            list[r[0]].add(r[1]);
            reverse[r[1]].add(r[0]);
        }
        
        for (int i = 1; i <= n; i++) {
            visit = new boolean[n + 1];
            int cnt = dfs(i, list) + dfs(i, reverse);
            
            answer = cnt == n - 1 ? answer + 1 : answer;
        }
        
        return answer;
    }
    
    static int dfs(int cur, ArrayList<Integer>[] list) {
        int cnt = 0;
        visit[cur] = true;
        
        for (int i : list[cur]) {
            if (visit[i]) continue;
            
            cnt += 1 + dfs(i, list);
        }
        
        return cnt;
    }
}