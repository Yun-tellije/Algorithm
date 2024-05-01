package algorithm.baekjoon;

import java.util.Scanner;

public class S4_10828 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int[] arr = new int[n];
        int top = 0;

        for (int i = 0; i < n; i++) {
            String s = sc.next();

            switch (s) {
                case "push":
                    arr[top] = sc.nextInt();
                    top++;
                    break;
                case "pop":
                    if (top <= 0) {
                        sb.append(-1 + "\n");
                        break;
                    }
                    top--;
                    sb.append(arr[top] + "\n");
                    break;
                case "top":
                    if (top <= 0) {
                        sb.append(-1 + "\n");
                        break;
                    }
                    sb.append(arr[top - 1] + "\n");
                    break;
                case "size":
                    sb.append(top + "\n");
                    break;
                case "empty":
                    if (top <= 0){
                        sb.append(1 + "\n");
                        break;
                    }
                    sb.append(0 + "\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}