import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][][] dp = new int[N+1][M+1][2];
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= M; j++) {
				Arrays.fill(dp[i][j], -100_000_000);
			}
		}
		int[] arr = new int[N+1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0][0][1] = 0;
		dp[0][0][0] = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= Math.min(M, i/2); j++) {
				dp[i][j][0] = Math.max(dp[i-1][j][1], dp[i-1][j][0]);
			}
			for (int j = 1; j <= Math.min(M, (i+1)/2); j++) {
				dp[i][j][1] = Math.max(dp[i-1][j-1][0], dp[i-1][j][1]) + arr[i];
			}
		}
		System.out.println(Math.max(dp[N][M][0], dp[N][M][1]));
	}
}
