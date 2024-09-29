package algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G2_7453 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int[][] arr = new int[n][4];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            for (int j = 0; j < 4; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] ab = new int[n * n];
        int[] cd = new int[n * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ab[(i * n) + j] = arr[i][0] + arr[j][1];
                cd[(i * n) + j] = arr[i][2] + arr[j][3];
            }
        }

        Arrays.sort(ab);
        Arrays.sort(cd);

        long cnt = 0;
        int left = 0;
        int right = n * n - 1;

        while (left < n * n && right >= 0) {
            int sum = ab[left] + cd[right];

            if (sum < 0) {
                left++;
            } else if (sum > 0) {
                right--;
            } else {
                long lCount = 1, rCount = 1;

                while (left + 1 < n * n && (ab[left] == ab[left + 1])) {
                    lCount++;
                    left++;
                }
                while (right > 0 && (cd[right] == cd[right - 1])) {
                    rCount++;
                    right--;
                }

                cnt += lCount * rCount;
                left++;
            }
        }

        System.out.println(cnt);
    }
}
