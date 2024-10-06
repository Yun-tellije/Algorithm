package algorithm.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class G3_16637 {

    static ArrayList<Character> ops;
    static ArrayList<Integer> nums;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        String arr = bf.readLine();

        ops = new ArrayList<>();
        nums = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            char c = arr.charAt(i);

            if (c == '+' || c == '-' || c == '*') {
                ops.add(c);
            }else {
                nums.add(Character.getNumericValue(c));
            }
        }

        dfs(nums.get(0), 0);
        System.out.println(answer);
    }

    static int calc(char op, int num1, int num2) {
        if (op == '+') {
            return num1 + num2;
        } else if (op == '-') {
            return num1 - num2;
        } else if (op == '*') {
            return num1 * num2;
        }

        return -1;
    }

    static void dfs(int result, int idx) {
        if (idx >= ops.size()) {
            answer = Math.max(answer, result);
            return;
        }

        int res = calc(ops.get(idx), result, nums.get(idx + 1));
        dfs(res, idx + 1);

        if (idx + 1 < ops.size()) {
            res = calc(ops.get(idx + 1), nums.get(idx + 1), nums.get(idx + 2));
            dfs(calc(ops.get(idx), result, res), idx + 2);
        }
    }
}
