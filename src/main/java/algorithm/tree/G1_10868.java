package algorithm.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G1_10868 {	

	static long[] arr, tree, lazy;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new long[n];
		tree = new long[n * 4];
		lazy = new long[n * 4];
		
		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		build(0, n - 1, 1);
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			sb.append(query(0, n - 1, a - 1, b - 1, 1)).append("\n");
		}
		
		
	    System.out.println(sb);
	}

	static long build(int start, int end, int node) {
		if (start == end) return tree[node] = arr[start];
		
		int mid = (start + end) / 2;
		return tree[node] = Math.min(build(start, mid, node * 2), build(mid + 1, end, node * 2 + 1));
	}
	
	static long query(int start, int end, int left, int right, int node) {
		if (right < start || end < left) return Long.MAX_VALUE;
		
		if (left <= start && end <= right) return tree[node];
		
		int mid = (start + end) / 2;
		return Math.min(query(start, mid, left, right, node * 2), query(mid + 1, end, left, right, node * 2 + 1));
	}
}
