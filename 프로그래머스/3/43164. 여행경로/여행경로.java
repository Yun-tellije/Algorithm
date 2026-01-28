import java.util.*;

class Solution {
    
    static String[] answer;
    static int n;
    static boolean[] visit;
    
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });
        
        n = tickets.length; 
        answer = new String[n + 1];
        visit = new boolean[n];
        
        answer[0] = "ICN";
        
        dfs("ICN", 0, tickets);
        
        return answer;
    }
    
    static boolean dfs(String cur, int depth, String[][] tickets) {
        if (depth == n) {
            return true;
        }
        
        for (int i = 0; i < n; i++) {
            if (!cur.equals(tickets[i][0]) || visit[i]) continue;
            
            visit[i] = true;
            answer[depth + 1] = tickets[i][1];
            
            if (dfs(tickets[i][1], depth + 1, tickets)) {
                return true;
            }
            
            visit[i] = false;
        }
        
        return false;
    }
}