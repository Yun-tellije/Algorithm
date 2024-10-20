package algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_21758 {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        arr = new int[n + 1];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(Math.max(leftHoney(), Math.max(midHoney(), rightHoney())));
    }

    static int leftHoney() {
        int[] sum = new int[arr.length];

        for (int i = arr.length - 2; i >= 1; i--) {
            sum[i] = sum[i + 1] + arr[i + 1];
        }

        int endSum = sum[1];

        int max = 0;

        for (int i = 2; i < arr.length; i++) {
            max = Math.max(max, endSum - arr[i] + sum[i]);
        }

        return max;
    }

    static int midHoney() {
        int[] leftSum = new int[arr.length];
        int[] rightSum = new int[arr.length];

        for (int i = 2; i < leftSum.length; i++) {
            leftSum[i] = leftSum[i - 1] + arr[i];
        }
        for (int i = rightSum.length - 2; i >= 1; i--) {
            rightSum[i] = rightSum[i + 1] + arr[i];
        }

        int max = 0;

        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, leftSum[i] + rightSum[i]);
        }

        return max;
    }

    static int rightHoney() {
        int[] sum = new int[arr.length];

        for (int i = 2; i < arr.length; i++) {
            sum[i] = sum[i - 1] + arr[i - 1];
        }

        int endSum = sum[arr.length - 1];
        int max = 0;

        for (int i = 1; i < arr.length - 1; i++) {
            max = Math.max(max, endSum - arr[i] + sum[i]);
        }

        return max;
    }
}
