package algorithm.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MST2_Prim {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine());
		int[][] adjMatrix= new int[V][V];		// 인접행렬
		boolean[] visit = new boolean[V];	// 트리정렬
		int[] minEdge = new int[V]; 		// 트리에 속한 타 정점들과 자신과의 최소간선비용
		
		for (int i = 0; i < V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < V; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 인접행렬 입력
		
		// step0: minEdge 배열 최대값으로 초기화 후 임의의 시작 정점이 트리에 속하는 시작 정점(0)이 되게 만들기
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		int result = 0; // mst 비용
		minEdge[0] = 0; // 루틴에 의해 정점이 선택되도록 처리
		
		for (int i = 0; i < V; i++) {
			// step1: 비트리정점중 트리에 속할 가장 유리한(간선의 비용이 적게 드는) 정점 찾기
			int min = Integer.MAX_VALUE;
			int minVertex = -1;
			
			for (int j = 0; j < V; j++) {
				if (!visit[j] && min > minEdge[j]) {
					min = minEdge[j];
					minVertex = j;
				}
			}
			
			result += min; // 트리 가중치의 합에 더하기
			visit[minVertex] = true; // 트리에 속한 정점으로 만들기
			
			// step2: 새롭게 확장된 트리 정점과 나머지 비트리 정점간의 최소간선비용 비교 후 업데이트
			for (int j = 0; j < V; j++) {
				if (!visit[j] // 비트리 정점 확인 
						&& adjMatrix[minVertex][j] != 0 // 인접 여부 확인 
						&& minEdge[j] > adjMatrix[minVertex][j]) // 최소 간선 비용 확인{
					minEdge[j] = adjMatrix[minVertex][j];
				
			}
		}
		System.out.println(result);
	}
}
