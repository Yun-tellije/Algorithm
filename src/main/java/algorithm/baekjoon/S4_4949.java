package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class S4_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s;

        while(true) {
            s = br.readLine();

            if (s.equals("."))
                break;

            if (s.charAt(s.length() - 1) != '.') {
                sb.append("no\n");
                continue;
            }

            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (c == '(' || c == '[') {
                    stack.push(c);
                }
                else if(c == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        stack.push(')');
                        break;
                    } else {
                        stack.pop();
                    }
                }
                else if(c == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        stack.push(']');
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }

            if (stack.empty()) {
                sb.append("yes\n");
            } else {
                sb.append("no\n");
            }
        }
        System.out.println(sb);
    }
}