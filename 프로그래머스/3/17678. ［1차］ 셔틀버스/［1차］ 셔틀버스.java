import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {        
        int[] arr = new int[timetable.length];
        
        for (int i = 0; i < timetable.length; i++) {
            String[] time = timetable[i].split(":");
            
            arr[i] = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
        }
        
        Arrays.sort(arr);
        
        int idx = 0;
        int lastTime = -1;
        int busTime = 9 * 60;
        int lastCount = 0;
        
        for (int i = 0; i < n; i++) {
           int count = 0;
            
            while (idx < arr.length && arr[idx] <= busTime && count < m) {
                lastTime = arr[idx];
                idx++;
                count++;
            }
            
            if (i == n - 1) {
                lastCount = count;
            }
            
            busTime += t;
        }
        
        busTime -= t;
        
        int answer = 0;
        
        if (lastTime == -1 || lastCount < m) {
            answer = busTime;
        } else {
            answer = lastTime - 1;
        }
        
        return String.format("%02d:%02d", answer / 60, answer % 60);
    }
}