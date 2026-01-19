import java.util.*;

class Solution {
        
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        ArrayList<Integer>[] list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < edge.length; i++) {
            list[edge[i][0]].add(edge[i][1]);
            list[edge[i][1]].add(edge[i][0]);
        }
        
        boolean[] visit = new boolean[n + 1];
        int[] depth = new int[n + 1];
        
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        visit[1] = true;
        depth[1] = 1;
        
        int max = -1;
        
        while (!q.isEmpty()) {
            int a = q.poll();
            
            for (int i : list[a]) {                
                if (visit[i]) continue;
                
                visit[i] = true;
                q.add(i);
                depth[i] = depth[a] + 1;
                
                if (depth[i] > max) {
                    max = depth[i];
                    answer = 0;
                }
                
                if (depth[i] == max) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}