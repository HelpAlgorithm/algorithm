package bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon14500_테트로미노 {
	static int[][] paper;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int M, N;
	static int ans;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		paper = new int[M][N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[M][N];

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				visited[i][j] = true;
				dfs(i, j, 1, paper[i][j]);
				t(i, j);
				visited[i][j] = false;
			}
		}
		System.out.println(ans);
	}
	
	
	static void dfs(int r, int c, int cnt, int sum) {
		if (cnt == 4) {
			ans = Math.max(ans, sum);
			return;
		}
		
		for (int dir = 0; dir < 4; dir++) {
			int nr = r + dr[dir], nc = c + dc[dir];
			if (nr < 0 || nr >= M || nc < 0 || nc >= N || visited[nr][nc]) continue;
			visited[nr][nc] = true;
			dfs(nr, nc, cnt+1, sum+paper[nr][nc]);
			visited[nr][nc] = false;
		}
	}
	
	
	static void t(int i, int j) {
		if (i > 0 && i < M-1 && j < N-1) {
			ans = Math.max(ans, paper[i-1][j]+paper[i][j]+paper[i+1][j]+paper[i][j+1]);
		}
		if (i > 0 && i < M-1 && j > 0) {
			ans = Math.max(ans, paper[i-1][j]+paper[i][j]+paper[i+1][j]+paper[i][j-1]);
		}
		if (i > 0 && j > 0 && j < N-1) {
			ans = Math.max(ans, paper[i-1][j]+paper[i][j]+paper[i][j-1]+paper[i][j+1]);
		}
		if (i < M-1 && j > 0 && j < N-1) {
			ans = Math.max(ans, paper[i][j]+paper[i+1][j]+paper[i][j-1]+paper[i][j+1]);
		}
	}

}
































