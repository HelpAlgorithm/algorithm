package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon15988_123더하기3 {

	public static void main(String[] args) throws IOException{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int[] tc = new int[t];
		long[] dp;
		int max = 0;
		for (int i = 0; i < t; i++) {
			tc[i] = Integer.parseInt(br.readLine());
			max = Math.max(tc[i], max);
		}
		
		dp = new long[Math.max(4, max+1)];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for (int i = 4; i <= max; i++) {
			dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % 1_000_000_009;
		}
		
		for (int i = 0; i < t; i++) {
			System.out.println(dp[tc[i]]);
		}
	}

}
