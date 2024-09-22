package algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_2512 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];
        int sum = 0;

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int high = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            high = Math.max(arr[i], high);
        }

        int max = Integer.parseInt(bf.readLine());

        if (sum <= max) {
            System.out.println(high);
            return;
        }

        int low = 1;

        while (low < high - 1) {
            int m = (low + high) / 2;

            int s = 0;
            for (int i = 0; i < n; i++) {
                s += Math.min(arr[i], m);
            }

            if (s > max) {
                high = m;
            } else {
                low = m;
            }
        }

        System.out.println(low);
    }
}