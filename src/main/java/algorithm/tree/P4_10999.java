import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P4_10999 {	

	static long[] arr, tree, lazy;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		arr = new long[n];
		tree = new long[n * 4];
		lazy = new long[n * 4];
		
		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		build(0, n - 1, 1);
		
		for (int i = 0; i < m + k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			
			if (a == 1) {
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				long d = Long.parseLong(st.nextToken());
				updateRange(0, n - 1, b - 1, c - 1, 1, d);
			} else {
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				sb.append(query(0, n - 1, b - 1, c - 1, 1)).append("\n");
			}
		}
		
	    System.out.println(sb);
	}
	
	static long build(int start, int end, int node) {
		if (start == end) return tree[node] = arr[start];
		
		int mid = (start + end) / 2;
		return tree[node] = build(start, mid, node * 2) + build(mid + 1, end, node * 2 + 1);
	}
	
	static void updateRange(int start, int end, int left, int right, int node, long value) {
		propagation(node, start, end); // lazy 값이 있으면 적용
		
		if (right < start || end < left) return;
		
		// 범위 내에 속한다면 lazy 적용
		if (start >= left && end <= right) {
			// 구간의 모든 값에 value 더해줌
			tree[node] += (end - start + 1) * value;
			// 자식일 경우 lazy 저장
			if (start != end) {
				lazy[node * 2] += value;
				lazy[node * 2 + 1] += value;
			}
			return;
		}

		int mid = (start + end) / 2;
		updateRange(start, mid, left, right, node * 2, value);
		updateRange(mid + 1, end, left, right, node * 2 + 1, value);
		
		tree[node] = tree[node * 2] + tree[node * 2 + 1];
	}
	
	static long query(int start, int end, int left, int right, int node) {
		propagation(node, start, end);
		
		if (right < start || end < left) return 0;
		
		if (start >= left && end <= right) return tree[node];
		
		int mid = (start + end) / 2;
		return query(start, mid, left, right, node * 2) + query(mid + 1, end, left, right, node * 2 + 1);
	}
	
	// lazy 값을 현재 노드에 반영하는 함수
	static void propagation(int node, int start, int end) {
		// lazy 값이 존재하지 않는다면 return
		if (lazy[node] == 0) return;
		
		// (end - start + 1) → 원소의 개수를 의미
		tree[node] += (end - start + 1) * lazy[node];
		// 자식일 경우 lazy 전파
		if (start != end) {
			lazy[node * 2] += lazy[node];
			lazy[node * 2 + 1] += lazy[node];
		}
		
		// 현재 노드의 lazy 초기화
		lazy[node] = 0;
	}
}
