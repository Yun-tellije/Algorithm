import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int left = i == 0 ? 1 : 0;
            int right = i == n - 1 ? n - 2 : n - 1;

            while (left < right) {
                int temp = arr[left] + arr[right];

                if (temp == arr[i]) {
                    answer++;
                    break;
                }

                if (temp > arr[i]) {
                    right--;
                    if (i == right) right--;
                } else {
                    left++;
                    if (i == left) left++;
                }
            }
        }

        System.out.println(answer);
    }
}