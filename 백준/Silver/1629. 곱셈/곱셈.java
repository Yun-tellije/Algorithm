import java.io.*;
import java.util.*;

public class Main {
	
	static long c;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		c = Long.parseLong(st.nextToken());
		System.out.println(pow(a, b));
	}
	
	static long pow(long num, long exponent) {
		if (exponent == 1) return num % c;
		
		long half = pow(num, exponent / 2);
		
		if (exponent % 2 == 0) {
			return half * half % c; 
		}
		return (half * half % c) * num % c;
	}
}
