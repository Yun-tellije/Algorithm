package algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S4_2217 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        Arrays.sort(arr);

        int max = 0;

        for (int i = 0; i < n; i++) {
            arr[i] *= (n - i);

            if (arr[i] > max) {
                max = arr[i];
            }
        }

        sb.append(max);

        System.out.println(sb);
    }
}
