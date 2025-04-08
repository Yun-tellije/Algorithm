package algorithm.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LIS {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] LIS = new int[n]; // 자신을 끝으로 하는 증가부분수열의 최장길이 
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0; // 최장증가부분수열의 길이
		for (int i = 0; i < n; i++) {
			LIS[i] = 1; // 자신만 끝에 세웠을 경우의 최장길이 1로 초기화
			for (int j = 0; j < i; j++) { // i보다 앞에 있는 모든 대상에 대해 탐색
				// 나보다 앞에 있는 j의 값이 나보다 작고 j 뒤에 i를 세우는 것이 더 최장을 만족한다면
				if (arr[j] < arr[i] && LIS[i] < LIS[j] + 1) { 
					LIS[i] = LIS[j] + 1;
				}
			}
		}
		System.out.println(max);
	}
}

/**
6
3 2 6 4 5 1
 */ 
