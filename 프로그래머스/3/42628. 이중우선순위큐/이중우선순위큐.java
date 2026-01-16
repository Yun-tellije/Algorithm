import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>((o1, o2) -> o2 - o1);
                
        for (int i = 0; i < operations.length; i++) {
            String[] arr = operations[i].split(" ");
            
            if (arr[0].equals("I")) {
                int num = Integer.parseInt(arr[1]);
                
                minPq.add(num);
                maxPq.add(num);
            } else {
                if (minPq.isEmpty()) continue;
                
                int num = Integer.parseInt(arr[1]);
                
                if (num == 1) {
                    int max = maxPq.poll();
                    minPq.remove(max);
                } else {
                    int min = minPq.poll();
                    maxPq.remove(min);
                }
            }
        }
        
        if (minPq.isEmpty()) {
            answer[0] = answer[1] = 0;
        } else {
            answer[0] = maxPq.poll();
            answer[1] = minPq.poll();
        }
        
        return answer;
    }
}