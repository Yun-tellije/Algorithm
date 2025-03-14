package algorithm.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P5_6549 {	

	static int[] arr, tree;
	static int n;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();		

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			if (n == 0) break;
			
			arr = new int[n];
			tree = new int[n * 4];
			
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			build(0, n - 1, 1);
			
			sb.append(getMax(0, n - 1)).append("\n");
		}
		
		
	    System.out.println(sb);
	}
	
	static int build(int start, int end, int node) {
		// 리프 노드에 도달했을 경우 인덱스 넣어줌
		if (start == end) return tree[node] = start;
		
		int mid = (start + end) / 2;
		
		int a = build(start, mid, node * 2);
		int b = build(mid + 1, end, node * 2 + 1);
		
		// 더 작은 높이의 인덱스 선택
		return tree[node] = arr[a] <= arr[b] ? a : b;
	}
	
	static int query(int start, int end, int left, int right, int node) {
		// 범위를 벗어났을 경우 -1
		if (start > right || end < left ) return -1;
		
		// 범위에 속할 경우 값 리턴
		if (left <= start && end <= right) return tree[node];
		
		int mid = (start + end) / 2;
		int a = query(start, mid, left, right, node * 2);
		int b = query(mid + 1, end, left, right, node * 2 + 1);
		
		// 왼쪽 노드의 범위가 벗어났다면 오른쪽 선택
		if (a == -1) return b;
		// 오른쪽 노드의 범위가 벗어났다면 왼쪽 선택 
		if (b == -1) return a;
		
		// 둘 다 범위 내에 속할 경우 더 작은 높이의 인덱스 선택
		return arr[a] <= arr[b] ? a : b;
	}
	
	static long getMax(int start, int end) {
		// 해당하는 범위에서 최소 높이 선택
		int m = query(0, n - 1, start, end, 1);
				
		// arr[m] → 높이
		// (end - start + 1) → 너비
		long s = (long)arr[m] * (end - start + 1);
		
		// 왼쪽 칸이 존재할 경우 확인
		if (start <= m - 1) {
			s = Math.max(s, getMax(start, m - 1));
		}
		// 오른쪽 칸이 존재할 경우 확인
		if (m + 1 <= end) {
			s = Math.max(s, getMax(m + 1, end));
		}
		
		return s;
	}
}
