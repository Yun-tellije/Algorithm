import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] arr = new long[m];
        long sum = 0;


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sum = (sum + Long.parseLong(st.nextToken())) % m;
            arr[(int)sum]++;
        }

        long answer = arr[0];

        for (int i = 0; i < m; i++) {
            long t = arr[i];
            answer += t * (t - 1) / 2;
        }

        System.out.println(answer);
    }
}
