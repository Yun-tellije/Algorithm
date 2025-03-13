package algorithm.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G1_1275 {	

	static long[] arr, tree, lazy;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		arr = new long[n];
		tree = new long[n * 4];
		lazy = new long[n * 4];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		build(0, n - 1, 1);
		
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (x > y) {
				sb.append(query(0, n - 1, y - 1, x - 1, 1)).append("\n");
			} else {
				sb.append(query(0, n - 1, x - 1, y - 1, 1)).append("\n");
			}
			update(0, n - 1, a - 1, 1, b);
		}
		
		
	    System.out.println(sb);
	}

	static long build(int start, int end, int node) {
		if (start == end) return tree[node] = arr[start];
		
		int mid = (start + end) / 2;
		return tree[node] = build(start, mid, node * 2) + build(mid + 1, end, node * 2 + 1);
	}
	
	static void update(int start, int end, int index, int node, int value) {
		if (index < start || end < index) return;
		
		if (index <= start && end <= index) {
			tree[node] = value;
			return;
		}
		
		int mid = (start + end) / 2;
		update(start, mid, index, node * 2, value);
		update(mid + 1, end, index, node * 2 + 1, value);
		tree[node] = tree[node * 2] + tree[node * 2 + 1];
	}
	
	static long query(int start, int end, int left, int right, int node) {
		if (right < start || end < left) return 0;
		
		if (left <= start && end <= right) return tree[node];
		
		int mid = (start + end) / 2;
		return query(start, mid, left, right, node * 2) + query(mid + 1, end, left, right, node * 2 + 1);
	}
}
