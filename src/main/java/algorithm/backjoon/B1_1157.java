package algorithm.backjoon;

import java.util.Scanner;

public class B1_1157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        int[] arr = new int[26];

        s = s.toUpperCase();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            arr[c - 65]++;
        }

        char answer = '?';
        int max = -1;

        for (int i = 0; i < 26; i++) {
            if (arr[i] > max) {
                max = arr[i];
                answer = (char) (i + 'A');
            } else if (arr[i] == max) {
                answer = '?';
            }
        }
        System.out.println(answer);
    }
}
