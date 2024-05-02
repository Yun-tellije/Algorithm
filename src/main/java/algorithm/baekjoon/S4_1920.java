package algorithm.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class S4_1920 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int[] arr1 = new int[n];

        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }

        Arrays.sort(arr1);

        int m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            int num = sc.nextInt();
            int idx = Arrays.binarySearch(arr1, num);

            if (idx >= 0) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }

        }

        System.out.println(sb);
    }
}