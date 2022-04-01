package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon11057_오르막수 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[10];
		for (int i = 0; i < 10; i++) {
			dp[i] = 1;
		}
		
		for (int t = 0; t< N; t++) {
			for (int i = 1; i < 10; i++) {
				dp[i] = (dp[i] + dp[i-1]) % 10007;
			}
		}
		System.out.println(dp[9]);
	}

}
