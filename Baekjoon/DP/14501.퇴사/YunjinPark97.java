package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon14501_퇴사 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] days = new int[N+1];
		int[] pays = new int[N+1];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			days[i+1] = Integer.parseInt(st.nextToken());
			pays[i+1] = Integer.parseInt(st.nextToken());
		}
		
		int ans = 0;
		int[] dp = new int[N+1]; 
		for (int i = 1; i <= N; i++) {
			if (days[i] + i <= N+1) dp[i] = pays[i];
			int temp = 0;
			for (int j = 1; j < i; j++) {
				if (days[j] + j <= i) {
					temp = Math.max(dp[j], temp);
				}
			}
			dp[i] += temp;
			ans = Math.max(ans, dp[i]);
		}
		
		//System.out.println(Arrays.toString(dp));
		System.out.println(ans);
	}

}
