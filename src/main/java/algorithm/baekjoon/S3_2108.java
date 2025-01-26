package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S3_2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];
        int[] count = new int[8001];


        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
            count[arr[i] + 4000]++;

            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        Arrays.sort(arr);

        double avg = 0;

        for (int i = 0; i < n; i++) {
            avg += arr[i];
        }

        int firstValue = 0;
        int secondValue = 0;
        boolean second = false;
        int maxCount = 0;

        for (int i = min + 4000; i <= max + 4000; i++) {
            if (count[i] > 0) {
                if (count[i] > maxCount) {
                    second = true;
                    firstValue = i - 4000;
                    maxCount = count[i];
                } else if (count[i] == maxCount && second) {
                    second = false;
                    secondValue = i - 4000;
                }
            }
        }

        int median = arr[n / 2];
        int range = arr[n - 1] - arr[0];
        int mode = second ? firstValue : secondValue;

        sb.append(Math.round(avg / n)).append("\n").append(median).append("\n").append(mode).append("\n").append(range);
        System.out.println(sb);
    }
}
