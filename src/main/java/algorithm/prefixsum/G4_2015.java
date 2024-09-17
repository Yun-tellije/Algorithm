package algorithm.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class G4_2015 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] sum = new int[n + 1];

        st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        long answer = 0;

        for (int i = 1; i <= n; i++) {
            answer += map.getOrDefault(sum[i] - k, 0);
            map.put(sum[i], map.getOrDefault(sum[i], 0) + 1);
        }

        sb.append(answer);

        System.out.println(sb);
    }
}
