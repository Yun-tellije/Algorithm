package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1_28702 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 3; i++) {
            String s = bf.readLine();

            if (s.matches("^[0-9]*$")) {
                int n = Integer.parseInt(s) + (3 - i);

                if (n % 3 == 0) {
                    if (n % 5 == 0) {
                        System.out.println("FizzBuzz");
                        return;
                    }
                    System.out.println("Fizz");
                    return;
                } else if (n % 5 == 0) {
                    System.out.println("Buzz");
                    return;
                } else {
                    System.out.println(n);
                    return;
                }
            }
        }
    }
}
