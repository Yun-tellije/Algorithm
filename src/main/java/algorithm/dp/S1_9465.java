import java.io.*;
import java.util.*;

public class S1_9465 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(bf.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(bf.readLine());
			int[][] arr = new int[2][n + 1];
			int[][] dp = new int[2][n + 1];
			
			for (int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				
				for (int j = 1; j <= n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dp[0][1] = arr[0][1];
			dp[1][1] = arr[1][1];
			
			for (int i = 2; i <= n; i++) {
				dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + arr[0][i];
				dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + arr[1][i];
			}
			
			sb.append(Math.max(dp[0][n], dp[1][n])).append("\n");
		}
		
		System.out.println(sb);
	}
}
