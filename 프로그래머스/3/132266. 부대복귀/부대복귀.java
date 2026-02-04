import java.util.*;

class Solution {
    
    static ArrayList<Integer>[] list;
    static int[] cost;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        cost = new int[n + 1];
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < roads.length; i++) {
            int a = roads[i][0];
            int b = roads[i][1];
            
            list[a].add(b);
            list[b].add(a);
        }
        
        bfs(destination, n);
        
        for (int i = 0; i < sources.length; i++) {
            int cur = sources[i];
            if (cur == destination) {
                answer[i] = 0;
                continue;
            }
            
            answer[i] = cost[cur] == 0 ? -1 : cost[cur];
        }        
        
        return answer;
    }
    
    static void bfs(int start, int n) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{start, 1});
        boolean[] visit = new boolean[n + 1];
        visit[start] = true;
        
        while (!q.isEmpty()) {
            int cur = q.peek()[0];
            int time = q.peek()[1];
            q.poll();
                        
            for (int i : list[cur]) {
                if (visit[i]) continue;
                                
                cost[i] = time;
                visit[i] = true;
                q.add(new int[]{i, time + 1});
            }
        }
    }
    
}