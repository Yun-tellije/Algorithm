class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int total = brown + yellow;
        
        // 가로가 세로보다 큼
        for (int i = 1; i <= total; i++) {
            if (total % i != 0) continue;
            
            int w = total / i;
            
            if ((w - 2) * (i - 2) == yellow) {
                answer[0] = Math.max(w, i);
                answer[1] = Math.min(w, i);
                return answer;
            }
        }
        return answer;
    }
}