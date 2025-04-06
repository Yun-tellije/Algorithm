package algorithm.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Dijkstra_PQ {

	static class Node {
		int vertex, weight;
		Node next;
		
		public Node(int vertex, int weight, Node next) {
			super();
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
	}
	
	static class Vertex implements Comparable<Vertex> {
		int no, minDistance; // 정점 번호, 출발지에서 자신까지의 최소비용

		public Vertex(int no, int minDistance) {
			super();
			this.no = no;
			this.minDistance = minDistance;
		}

		@Override
		public int compareTo(Vertex o) { // 비용의 최소 기준: 오름차순 -> 최소합
			return this.minDistance - o.minDistance;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		// 최단 경로의 값(정점수 -1만큼의 간선의 가중치의 합)은 int의 최대값을 넘지 않는다
		final int INF = Integer.MAX_VALUE;
		
		Node[] adjList = new Node[V];		// 인접리스트
		int[] minDistance = new int[V];		// 출발지에서 자신으로의 최단경로비용
		boolean[] visit = new boolean[V];	// 방문된 정점 여부
		
		// 인접리스트 만들기
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adjList[from] = new Node(to, weight, adjList[from]);
		}
		
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		Arrays.fill(minDistance, INF);
		minDistance[start] = 0;
		pq.offer(new Vertex(start,  minDistance[start]));
		
		while (!pq.isEmpty()) {
			// step1: 미방문 정점중 출발지에서 가장 가까운 정점 찾기
			Vertex stopOver = pq.poll();
			if (visit[stopOver.no]) continue;
			
			visit[stopOver.no] = true;
			if(stopOver.no == end) break;
			
			// step2: 선택된 정점을 경유해서 갈 수 있는 비방문 정점들의 최단경로 비용 update
			for (Node temp = adjList[stopOver.no]; temp != null; temp = temp.next) {
				if (!visit[temp.vertex] && minDistance[temp.vertex] > stopOver.minDistance + temp.weight) {
					minDistance[temp.vertex] = stopOver.minDistance + temp.weight;
					pq.offer(new Vertex(temp.vertex, minDistance[temp.vertex]));
				}
			}	
		}
		
		System.out.println(minDistance[end] == INF ? - 1 : minDistance[end]);
	}
}
