import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String find = br.readLine();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));

            if (stack.size() >= find.length()) {
                boolean enable = true;
                for (int j = 0; j < find.length(); j++) {
                    if (stack.get(stack.size() - find.length() + j) != find.charAt(j)) {
                        enable = false;
                        break;
                    }
                }

                if (!enable) continue;;

                for (int j = 0; j < find.length(); j++) {
                    stack.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }

        System.out.println(sb.length() == 0 ? "FRULA" : sb);
    }
}
