package algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G5_2470 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int[] answer = new int[2];

        int start = 0;
        int end = n - 1;
        int min = Integer.MAX_VALUE;

        while (start < end) {
            int sum = arr[start] + arr[end];

            if (Math.abs(sum) < min) {
                answer[0] = arr[start];
                answer[1] = arr[end];
                min = Math.abs(sum);


                if (sum == 0)
                    break;
            }

            if (sum < 0) {
                start++;
            } else {
                end--;
            }
        }

        sb.append(answer[0] + " " + answer[1]);
        System.out.println(sb);
    }
}
