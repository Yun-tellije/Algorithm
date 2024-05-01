package algorithm.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class S4_11399 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        int[] arr = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            sum += arr[i] * (n - i);
        }
        sb.append(sum);

        System.out.println(sb);
    }
}