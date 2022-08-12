import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		int[][] dp = new int[R+1][C+1];
		for (int i = 1; i <= R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= C; j++) {
				dp[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				dp[i][j] += dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while (Q-- > 0) {
			st = new StringTokenizer(br.readLine());
			int r1 = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			sb.append((dp[r2][c2]-dp[r1-1][c2]-dp[r2][c1-1]+dp[r1-1][c1-1]) / ((r2 - r1 + 1) * (c2 - c1 + 1))+"\n");
		}
		System.out.println(sb.toString());
	}
}
