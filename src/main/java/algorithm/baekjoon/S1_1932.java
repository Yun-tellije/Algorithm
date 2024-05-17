package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_1932 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] temp = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                temp[j] = arr[j];
            }
            for (int j = 0; j < i + 1; j++) {
                int a = Integer.parseInt(st.nextToken());
                if (j > 0 && j < i) {
                    arr[j] = a + (Math.max(temp[j], temp[j - 1]));
                }
                else if(j == 0){
                    arr[j] += a;
                }
                else if (j == i) {
                    arr[j] = a + temp[j - 1];
                }
            }
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        sb.append(max);

        System.out.println(sb);
    }
}