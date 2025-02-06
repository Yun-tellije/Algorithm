package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S4_18110 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        Arrays.sort(arr);

        int range = (int) Math.round(n * 0.15);

        double sum = 0;
        for (int i = range; i < n -range; i++) {
            sum += arr[i];
        }

        int answer = (int) Math.round(sum / (n - range * 2));
        System.out.println(answer);
    }
}
