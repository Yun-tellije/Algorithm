package algorithm.baekjoon;

import java.util.Scanner;

public class S4_9012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            int count = 0;
            for (int j = 0; j < s.length(); j++) {
                if (count < 0)
                    break;
                if (s.charAt(j) == '(')
                    count++;
                else if(s.charAt(j) == ')')
                    count--;
            }
            if (count == 0)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}