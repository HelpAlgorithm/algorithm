package bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon2206_벽부수고이동하기_개선 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// M, N 바꿔썼음
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		int[][] map = new int[M][N];
		int[][] dist1 = new int[M][N];
		int[][] dist2 = new int[M][N];
		dist1[0][0] = 1;
		dist2[0][0] = 1;
		
		
		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		
		Queue<int[]> queue = new ArrayDeque<>(); // {row, col, 벽부셨는지 0 or 1로}
		queue.offer(new int[] {0, 0, 0});
		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			int row = temp[0];
			int col = temp[1];
			int broken = temp[2];
			for (int i = 0; i < 4; i++) {
				int nr = row + dr[i];
				int nc = col + dc[i];
				if (nr < 0 || nr >= M || nc < 0 || nc >= N) continue;
				if (broken == 0) {
					if (map[nr][nc] == 1 && (dist2[nr][nc] == 0 || dist2[nr][nc] > dist1[row][col] + 1)) {
						dist2[nr][nc] = dist1[row][col] + 1;
						queue.offer(new int[] {nr, nc, 1});
					}
					else if (map[nr][nc] == 0 && (dist1[nr][nc] == 0 || dist1[nr][nc] > dist1[row][col] + 1)) {
						dist1[nr][nc] = dist1[row][col] + 1;
						queue.offer(new int[] {nr, nc, broken});
					}
				}
				else {
					if (map[nr][nc] == 0 && (dist2[nr][nc] == 0 || dist2[nr][nc] > dist2[row][col] + 1)) {
						dist2[nr][nc] = dist2[row][col] + 1;
						queue.offer(new int[] {nr, nc, broken});
					}
				}
			}
		}
		
		if (dist1[M-1][N-1] == 0) {
			if (dist2[M-1][N-1] == 0) {
				System.out.println(-1);
			}
			else {
				System.out.println(dist2[M-1][N-1]);
			}
		}
		else {
			if (dist2[M-1][N-1] == 0) {
				System.out.println(dist1[M-1][N-1]);
			}
			else {
				System.out.println(Math.min(dist1[M-1][N-1], dist2[M-1][N-1]));

			}
		}
		
			
	}

}










