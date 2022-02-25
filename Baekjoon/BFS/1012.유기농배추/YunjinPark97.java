package bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon1012_유기농배추 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] farm = new int[M][N];
			int K = Integer.parseInt(st.nextToken());
			Queue<int[]> queue = new ArrayDeque<int[]>();
			int num = 0;
			
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				int col = Integer.parseInt(st.nextToken());
				int row = Integer.parseInt(st.nextToken());
				farm[row][col] = 1;
			}
			
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (farm[i][j] == 1) {
						num++;
						farm[i][j] = -1;
						queue.offer(new int[] {i, j});
						while (!queue.isEmpty()) {
							int[] temp = queue.poll();
							int r = temp[0];
							int c = temp[1];
							for (int dir = 0; dir < 4; dir++) {
								int nr = r + dr[dir];
								int nc = c + dc[dir];
								if (nr < 0 || nr >= M || nc < 0 || nc >= N) continue;
								if (farm[nr][nc] <= 0) continue;
								farm[nr][nc] = -1;
								queue.offer(new int[] {nr, nc});
							}
						}
					}
				}
			}
			System.out.println(num);
		}
	}

}
