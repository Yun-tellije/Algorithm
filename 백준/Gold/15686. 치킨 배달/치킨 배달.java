import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m, answer = Integer.MAX_VALUE;
	static int[][] arr;
	static List<Node> c, h;
	static boolean[] selected;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		c = new ArrayList<>();
		h = new ArrayList<>();
		
		// 0은 빈칸, 1은 집, 2는 치킨집
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				
				if (arr[i][j] == 1) h.add(new Node(i, j));
				if (arr[i][j] == 2) c.add(new Node(i, j));
			}
		}
		
		selected = new boolean[c.size()];
		select(0, 0);
		
		System.out.println(answer);
	}
	
	static void select(int depth, int index) {
		if (depth == m) {
			check();
			return;
		}
		if (index == c.size()) return;
		
		selected[index] = true;
		select(depth + 1, index + 1);
		selected[index] = false;
		
		select(depth, index + 1);
	}
	
	static void check() {
		// 선택된 치킨집과 집과의 거리 중 제일 가까운 치킨집 확인
		int sum = 0;
		for (int i = 0; i < h.size(); i++) {
			int min = Integer.MAX_VALUE;
			Node n1 = h.get(i);
			for (int j = 0; j < c.size(); j++) {
				if (!selected[j]) continue;
				
				Node n2 = c.get(j);
				int l = Math.abs(n1.x - n2.x) + Math.abs(n1.y - n2.y);
				
				min = Math.min(min, l);
			}
			sum += min;
		}
		
		answer = Math.min(answer, sum);
	}
	
	static class Node{
		int x;
		int y;
		
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}