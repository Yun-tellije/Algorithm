import java.io.*;
import java.util.*;

class S2_2630 {
	
	static class Point {
		int x;
		int y;
		int len;
		
		Point (int x, int y, int len) {
			this.x = x;
			this.y = y;
			this.len = len;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(bf.readLine());
		int[][] arr = new int[n][n];
		
		int whiteCount = 0; // 0
		int blueCount = 0;  // 1
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
				
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0, n));
		while (!q.isEmpty()) {
			Point p = q.poll();
			int x = p.x;
			int y = p.y;
			int len = p.len;
			
			int check = arr[x][y];
			boolean diff = false;
			for (int i = x; i < x + len; i++) {
				for (int j = y; j < y + len; j++) {
					if (check != arr[i][j]) {
						diff = true;
						break;
					}
				}
				if (diff) {
					break;
				}
			}
			if (!diff) {
				if (check == 0) {
					whiteCount++;
				} else {
					blueCount++;
				}
			} else {
				len /= 2;
				q.add(new Point(x, y, len));
				q.add(new Point((x + len), y, len));
				q.add(new Point(x, (y + len), len));
				q.add(new Point((x + len), (y + len), len));
			}
		}
		
		System.out.println(whiteCount);
		System.out.println(blueCount);
	}
}
