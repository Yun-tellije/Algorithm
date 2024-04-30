package algorithm.baekjoon;

import java.util.Scanner;

public class S5_11866 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = 1;
        }

        int j = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            while (true) {
                if (arr[j] == 1) {
                    count++;
                }

                if (count == k) {
                    break;
                }
                j = (j + 1) % n;
            }

            answer[i] = j + 1;
            arr[j] = 0;
        }

        System.out.print('<');
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                System.out.print(answer[i]);
                break;
            }
            System.out.print(answer[i] + ", ");
        }
        System.out.print('>');
    }
}
