import java.util.*;

class Solution {
    
    static String[] uId, bId;
    static boolean[] visit;
    static Set<String> set = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        uId = user_id;
        bId = banned_id;
        visit = new boolean[user_id.length];
        
        dfs(0);
        
        return set.size();
    }
    
    static void dfs(int depth) {
        if (depth == bId.length) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < uId.length; i++) {
                sb.append(visit[i] ? '1' : '0');
            }
            set.add(sb.toString());    
            return;
        }
        
        for (int i = 0; i < uId.length; i++) {
            if (visit[i] || !match(uId[i], bId[depth])) continue;
            
            visit[i] = true;
            dfs(depth + 1);
            visit[i] = false;
        }
    }
    
    static boolean match(String user, String ban) {
        if (user.length() != ban.length()) return false;
        
        for (int i = 0; i < user.length(); i++) {
            if (ban.charAt(i) == '*') continue;
            if (user.charAt(i) != ban.charAt(i)) return false;
        }
        
        return true;
    }
}