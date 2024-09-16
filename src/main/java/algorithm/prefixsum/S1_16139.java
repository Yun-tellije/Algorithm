package algorithm.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_16139 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = bf.readLine();
        int n = Integer.parseInt(bf.readLine());
        int[][] arr = new int[s.length() + 1][26];

        for (int i = 1; i <= s.length(); i++) {
            int search = s.charAt(i - 1) - 'a';


            for (int j = 0; j < 26; j++) {
                int prev = arr[i - 1][j];
                if (search == j) {
                    arr[i][j]++;
                }
                arr[i][j] += prev;
            }
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int search = st.nextToken().charAt(0) - 'a';
            int start = Integer.parseInt(st.nextToken()) + 1;
            int end = Integer.parseInt(st.nextToken()) + 1;

            sb.append(arr[end][search] - arr[start - 1][search]).append("\n");
        }

        System.out.println(sb);
    }
}
