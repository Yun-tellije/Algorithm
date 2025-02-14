package algorithm.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_TEST_2105 {

	static int[] dx = {1, 1, -1, -1};
	static int[] dy = {1, -1, -1, 1};
	static int[][] arr;
	static boolean[][] visit;
	static boolean[] cake;
	static int n;
	static int max;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
			
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			visit = new boolean[n][n];
			cake = new boolean[101];
			max = -1;
			
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					dfs(i, j, 0, i, j, 0);
				}
			}
			
			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		
		System.out.println(sb);
	}

	static void dfs(int startX, int startY, int d, int x, int y, int cnt) {
		if (visit[startX][startY]) {
			max = Math.max(max, cnt);
			return;
		}
		
		for (int i = d; i < 4; i++) {
			int cx = x + dx[i];
			int cy = y + dy[i];
			
			if (cx < 0 || cx >= n || cy < 0 || cy >= n) {
				continue;
			}
			
			if (visit[cx][cy] || cake[arr[cx][cy]]) {
				continue;
			}
			
			if (i > d + 1) {
				continue;
			}
			
			visit[cx][cy] = true;
			cake[arr[cx][cy]] = true;
			dfs(startX, startY, i, cx, cy, cnt + 1);
			visit[cx][cy] = false;
			cake[arr[cx][cy]] = false;
		}
	}	
}
