package algorithm.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S4_2164 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        int answer = 0;

        for (int i = 0; i < n; i++) {
            q.add(i + 1);
        }

        while (q.size() > 1) {
            q.remove();
            int temp = q.remove();
            q.add(temp);
        }
        answer = q.remove();

        sb.append(answer);

        System.out.println(sb);
    }
}