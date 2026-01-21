import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int index = 0;
        
        for (int i = 0; i < A.length; i++) {
            while (true) {
                if (index >= A.length) break;
                
                if (A[i] < B[index]) {
                    answer++;
                    index++;
                    break;
                }
                index++;
            }
                        
            if (index >= A.length) break;
        }
        
        return answer;
    }
}