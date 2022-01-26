package algorithm_me;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Kyeee2 {

	static int M;
	static int N;
	static boolean [] checks; // 체크했는가?

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens = new StringTokenizer(br.readLine(), " ");
		
		M = Integer.parseInt(tokens.nextToken());
		N = Integer.parseInt(tokens.nextToken());
		
		checks = new boolean[N + 1];
		
		checks[0] = checks[1] = true;
		for(int n = 2; n <= N; n++) {
			if(!checks[n]) {
				check(n);
			}
		}
		
		for(int n = M; n <= N; n++) {
			if(!checks[n]) {
				System.out.println(n);
			}
		}
	}
	
	// 소수 체크
	public static boolean isPrime(int n) {
		for(int i = 2; i * i <= n; i++) {
			if(n % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	// 소수의 배수
	public static void check(int n) {
		for(int i = 2 * n; i <= N; i += n) {
			checks[i] = true;
		}		
	}

}
