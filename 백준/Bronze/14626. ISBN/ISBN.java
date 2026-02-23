import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int check = 0;
        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c != '*') {
                num += i % 2 == 0 ? c - '0' : (c - '0') * 3;
            } else {
                check = i;
            }
        }

        int answer = 0;
        while (true) {
            if (check % 2 == 0) {
                if ((num + answer) % 10 == 0) {
                    System.out.println(answer);
                    break;
                }
            } else {
                if ((num + answer * 3) % 10 == 0) {
                    System.out.println(answer);
                    break;
                }
            }
            answer++;
        }
    }
}
