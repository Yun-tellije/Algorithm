package algorithm.bfs;

import java.io.*;
import java.util.*;

public class G4_4485 {
	
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	
	static int n;
	static int[][] arr;
	static int[][] map;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int index = 0;
		while (true) {
			n = Integer.parseInt(br.readLine());
			
			if (n == 0) {
				break;
			}
			index++;
			arr = new int[n][n];
			map = new int[n][n];
			
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					map[i][j] = Integer.MAX_VALUE;
				}
			}
			map[0][0] = arr[0][0];
			
			bfs();

			sb.append("Problem ").append(index).append(": ").append(map[n - 1][n - 1]).append("\n");
		}
		
		
		System.out.println(sb);
	}

	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0, 0});
		
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.poll();
			
			if (x == n - 1 && y == n - 1) {
				continue;
			}
			
			for (int i = 0; i < 4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				
				if (cx < 0 || cx >= n || cy < 0 || cy >= n) {
					continue;
				}
				
				int temp = map[x][y] + arr[cx][cy];
				
				if (map[cx][cy] > temp) {
					map[cx][cy] = temp;
					q.add(new int[] {cx, cy});
				}
			}
		}
	}
}
