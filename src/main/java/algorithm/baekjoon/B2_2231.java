package algorithm.baekjoon;

import java.util.Scanner;

public class B2_2231 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int sum = num + 1;

        for (int i = 1; i <= num; i++) {
            int j = i;
            int temp = 0;
            while (j > 0) {
                temp += j % 10;
                j /= 10;
            }
            temp += i;

            if (temp == num && temp < sum) {
                sum = i;
            }
        }

        if (sum == num + 1)
            sum = 0;
        System.out.println(sum);
    }
}
