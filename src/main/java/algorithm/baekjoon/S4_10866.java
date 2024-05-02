package algorithm.baekjoon;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class S4_10866 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        Deque<Integer> dq = new ArrayDeque<>();
        int size = 0;

        for (int i = 0; i < n; i++) {
            String s = sc.next();

            switch (s) {
                case "push_front":
                    dq.addFirst(sc.nextInt());
                    size++;
                    break;
                case "push_back":
                    dq.addLast(sc.nextInt());
                    size++;
                    break;
                case "pop_front":
                    if (dq.isEmpty()) {
                        sb.append(-1).append("\n");
                        break;
                    }
                    sb.append(dq.removeFirst()).append("\n");
                    size--;
                    break;
                case "pop_back":
                    if (dq.isEmpty()) {
                        sb.append(-1).append("\n");
                        break;
                    }
                    sb.append(dq.removeLast()).append("\n");
                    size--;
                    break;
                case "size":
                    sb.append(size).append("\n");
                    break;
                case "empty":
                    if (dq.isEmpty())
                        sb.append(1).append("\n");
                    else
                        sb.append(0).append("\n");
                    break;
                case "front":
                    if (dq.isEmpty()) {
                        sb.append(-1).append("\n");
                        break;
                    }
                    sb.append(dq.getFirst()).append("\n");
                    break;
                case "back":
                    if (dq.isEmpty()) {
                        sb.append(-1).append("\n");
                        break;
                    }
                    sb.append(dq.getLast()).append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }
}