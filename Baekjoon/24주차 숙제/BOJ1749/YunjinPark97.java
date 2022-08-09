import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] dp = new int[N+1][M+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				dp[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++ ) {
				dp[i][j] += dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
			}
		}
		
		int ans = (int) -1e09;
		for (int x1 = 0; x1 < N; x1++) {
			for (int y1 = 0; y1 < M; y1++) {
				for (int x2 = x1 + 1; x2 <= N; x2++) {
					for (int y2 = y1 + 1; y2 <= N; y2++) {
						int cur = dp[x2][y2] - dp[x1][y2] - dp[x2][y1] + dp[x1][y1];
						if (cur > ans) ans = cur;
					}
				}
			}
		}
		System.out.println(ans);
	}

}
