package algorithm.baekjoon;

import java.util.Scanner;

public class S4_10773 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        int j = 0;

        for (int i = 0; i < n; i++) {
            arr[j] = sc.nextInt();
            if (arr[j] == 0) {
                sum -= arr[j - 1];
                j--;
            } else {
                sum += arr[j];
                j++;
            }
        }

        System.out.println(sum);
    }
}