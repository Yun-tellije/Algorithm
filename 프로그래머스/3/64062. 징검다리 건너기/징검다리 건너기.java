class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        
        int left = 1;
        int right = 0;
        
        for (int stone : stones) {
            right = Math.max(right, stone);
        }
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            int skip = 0;
            boolean cross = true;
            
            for (int stone : stones) {
                if (stone < mid) skip++;
                else skip = 0;
                
                if (skip == k) {
                    cross = false;
                    break;
                }
            }
            
            if (cross) {
                answer = mid;
                left = mid + 1;
                continue;
            }
            
            right = mid - 1;
        }
        
        return answer;
    }
}