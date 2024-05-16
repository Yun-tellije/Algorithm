package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S5_11723 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[20];
        int idx;

        for (int i = 0; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            switch (s) {
                case "add" :
                    idx = Integer.parseInt(st.nextToken()) - 1;
                    arr[idx] = 1;
                    break;
                case "remove" :
                    idx = Integer.parseInt(st.nextToken()) - 1;
                    arr[idx] = 0;
                    break;
                case "check" :
                    idx = Integer.parseInt(st.nextToken()) - 1;
                    sb.append(arr[idx]).append("\n");
                    break;
                case "toggle" :
                    idx = Integer.parseInt(st.nextToken()) - 1;
                    if (arr[idx] == 0)
                        arr[idx] = 1;
                    else
                        arr[idx] = 0;
                    break;
                case "all" :
                    Arrays.fill(arr, 1);
                    break;
                case "empty" :
                    Arrays.fill(arr, 0);
                    break;
            }
        }

        System.out.println(sb);
    }
}