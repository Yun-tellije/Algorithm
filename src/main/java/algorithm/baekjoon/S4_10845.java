package algorithm.baekjoon;

import java.util.Scanner;

public class S4_10845 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int[] arr = new int[n];
        int front = 0;
        int back = 0;

        for (int i = 0; i < n; i++) {
            String s = sc.next();

            switch (s) {
                case "push":
                    arr[back] = sc.nextInt();
                    back++;
                    break;
                case "pop":
                    if (front == back) {
                        sb.append(-1 + "\n");
                        break;
                    }
                    sb.append(arr[front] + "\n");
                    front++;
                    break;
                case "front":
                    if (front == back){
                        sb.append(-1 + "\n");
                        break;
                    }
                    sb.append(arr[front] + "\n");
                    break;
                case "back":
                    if (front == back){
                        sb.append(-1 + "\n");
                        break;
                    }
                    sb.append(arr[back - 1] + "\n");
                    break;
                case "size":
                    sb.append((back - front) + "\n");
                    break;
                case "empty":
                    if (front == back){
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
