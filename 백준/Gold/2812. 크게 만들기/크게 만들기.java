import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String num = br.readLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            char cur = num.charAt(i);

            while (!stack.isEmpty() && k > 0 && stack.peek() < cur) {
                stack.pop();
                k--;
            }
            stack.push(cur);
        }

        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        System.out.println(sb.toString());
    }
}
