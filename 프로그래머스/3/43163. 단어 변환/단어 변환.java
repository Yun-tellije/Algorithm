import java.util.*;

class Solution {
    
    static boolean[] visit;
    static int answer;
    static String tar;
    
    public int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE;
        tar = target;
        visit = new boolean[words.length];
        
        for (int i = 0; i < words.length; i++) {
            if (check(begin, words[i])) {
                visit[i] = true;
                dfs(1, i, words);
                visit[i] = false;
            }
        }
        
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    
    static void dfs(int depth, int index, String[] words) {
        String cur = words[index];
        if (cur.equals(tar)) {
            answer = Math.min(answer, depth);
            return; 
        }
        
        for (int i = 0; i < words.length; i++) {
            if (visit[i]) continue;
            
            if (check(cur, words[i])) {
                visit[i] = true;
                dfs(depth + 1, i, words);
                visit[i] = false;
            }
        }
    }
    
    static boolean check(String cur, String next) {
        int cnt = 0;
        
        for (int i = 0; i < cur.length(); i++) {
            if (cur.charAt(i) == next.charAt(i)) continue;
            
            if (++cnt > 1) {
                return false;
            }
        }
        
        return true;
    }
}