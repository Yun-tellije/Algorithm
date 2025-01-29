package algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G4_9663 {

    static int n;
    static int[] arr;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        arr = new int[n];

        queen(0);
        System.out.println(count);
    }

    static void queen(int depth) {
        if (depth == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            arr[depth] = i;

            if (check(depth)) {
                queen(depth + 1);
            }
        }
    }

    static boolean check(int c) {
        for (int i = 0; i < c; i++) {
            if (arr[c] == arr[i]) {
                return false;
            } else if (Math.abs(c - i) == Math.abs(arr[c] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}
