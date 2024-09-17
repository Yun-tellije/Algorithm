package algorithm.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class G3_2900 {

    static int n;
    static int[] arr;

    static void something(int jump, int cnt) {
        int i = 0;
        while (i <= n) {
            arr[i] += cnt;
            i += jump;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new int [n + 1];

        HashMap<Integer, Integer> map = new HashMap<>();
        st = new StringTokenizer(bf.readLine());

        for (int i = 1; i <= k; i++) {
            int x = Integer.parseInt(st.nextToken());
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (int key : map.keySet()) {
            something(key, map.get(key));
        }

        long[] sum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + arr[i - 1];
        }

        int q = Integer.parseInt(bf.readLine());

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(sum[b + 1] - sum[a] + "\n");
        }
        System.out.println(sb);
    }
}
