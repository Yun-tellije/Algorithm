package algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G4_2110 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        Arrays.sort(arr);

        int low = 1;
        int high = arr[n - 1] - arr[0] + 1;

        while (low < high) {
            int mid = (low + high) / 2;

            int cnt = 1;
            int last = arr[0];

            for (int i = 1; i < n; i++) {
                if (arr[i] - last >= mid) {
                    cnt++;
                    last = arr[i];
                }
            }

            if (cnt >= m) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        sb.append(low - 1);
        System.out.println(sb);
    }
}
