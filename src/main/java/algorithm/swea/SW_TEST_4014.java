package algorithm.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_TEST_4014 {

    static int n, x;
    static int[][] arr1, arr2;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());

            arr1 = new int[n][n];
            arr2 = new int[n][n];
            answer = 0;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    arr1[i][j] = num;
                    arr2[j][i] = num;
                }
            }

            check(arr1);
            check(arr2);

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    static void check(int[][] arr) {
        for (int i = 0; i < n; i++) {
            boolean enable = true;
            int count = 1;
            for (int j = 1; j < n; j++) {
                // 높이 같을 때
                if (arr[i][j] == arr[i][j - 1]) {
                    count++;
                    continue;
                }

                // 현재 위치가 이전 위치보다 위일 때
                if (arr[i][j] == arr[i][j - 1] + 1) {
                    if (count < x) {
                        enable = false;
                        break;
                    }

                    count = 1;
                }
                // 현재 위치가 이전 위치보다 아래일 때
                else if (arr[i][j] == arr[i][j - 1] - 1) {
                    if (j + x > n) {
                        enable = false;
                        break;
                    }

                    boolean ck = true;
                    for (int k = j; k < j + x; k++) {
                        if (arr[i][j] != arr[i][k]) {
                            ck = false;
                            break;
                        }
                    }

                    if (!ck) {
                        enable = false;
                        break;
                    }

                    j += x - 1;
                    count = 0;
                }
                // 높이가 2이상 차이날 때
                else {
                    enable = false;
                    break;
                }
            }
            if (enable) {
                answer++;
            }
        }
    }
}
