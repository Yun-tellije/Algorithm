package algorithm.study;

import java.io.IOException;

public class SegmentTree {
	
	// 원본 배열
	static int[] arr;
	// 세그먼트 트리
	static int[] tree;
	
	public static void main(String[] args) throws IOException{
		int n = 6;
		arr = new int[] {1, 3, 5, 7, 9, 11};
		tree = new int[4 * n]; 
		
		build(0, n - 1, 1);
		
		System.out.println("구간 합 (2~5): " + query(0, n - 1, 1, 2, 5)); // 5+7+9+11 = 32

	    update(0, n - 1, 1, 3, 6); // arr[3] = 7 → 6으로 변경
	    System.out.println("구간 합 (2~5) after update: " + query(0, n - 1, 1, 2, 5)); // 5+6+9+11 = 31
	}
	
	// 1. 세그먼트 트리 생성
	static int build(int start, int end, int node) {
		
		if (start == end) return tree[node] = arr[start]; // 리프 노트
				
		int mid = (start + end) / 2;
		// build(start, mid, node * 2) -> 왼쪽 자식
		// build(mid + 1, end , node * 2 + 1) -> 오른쪽 자식
		return tree[node] = build(start, mid, node * 2) + build(mid + 1, end, node * 2 + 1);
	}
	
	// 2. 구간 합 질의
	static int query(int start, int end, int node, int left, int right) {
		if (right < start || left > end) return 0; // 범위 벗어남
		if (left <= start && end <= right) return tree[node]; // 범위 포함
		
		int mid = (start + end) / 2;
		return query(start, mid, node * 2, left, right) + query(mid + 1, end, node * 2 + 1, left, right);
	}
	
	// 3. 값 업데이트
	static void update(int start, int end, int node, int index, int value) {
		if (index < start || index > end) return; // 범위 벗어남
		if (start == end) {
			tree[node] = value;
			arr[index] = value;
			return;
		}
		
		int mid = (start + end) / 2;
		update(start, mid, node * 2, index, value);
		update(mid + 1, end, node * 2 + 1, index, value);
		
		tree[node] = tree[node * 2] + tree[node * 2 + 1]; // 부모 노드 업데이트
	}
}






