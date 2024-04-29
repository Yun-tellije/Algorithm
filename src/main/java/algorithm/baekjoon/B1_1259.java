package algorithm.baekjoon;

import java.util.Scanner;

public class B1_1259 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        while(sc.hasNext()) {
            String s = sc.nextLine();
            if (s.equals("0"))
                break;
            boolean b = true;

            for (int i = 0; i < s.length() / 2; i++) {
                if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                    b = false;
                }
            }

            if (b == true)
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }
}