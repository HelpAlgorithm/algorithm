package boj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Chiyongs {

	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int N,M;
	static int[][] map;
	static int[][] dist1,dist2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		dist1 = new int[N][M];
		dist2 = new int[N][M];
		for(int i=0;i<N;i++) {
			String input = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}
		
		bfs(new Integer[] {0,0,0});
		
		int result1 = dist1[N-1][M-1];
		int result2 = dist2[N-1][M-1];

		if(result1 ==0 && result2 == 0) {
			System.out.println(-1);
		} else {
			if(result1 == 0) {
				System.out.println(result2);
			} else if(result2 == 0) {
				System.out.println(result1);
			} else {
				System.out.println(Math.min(result1, result2));
			}
		}		

	}
	
	private static void bfs(Integer[] start) {
		Queue<Integer[]> Q = new LinkedList<>();
		Q.offer(start);
		dist1[start[0]][start[1]] = 1;
		dist2[start[0]][start[1]] = 1;
		
		while(!Q.isEmpty()) {
			Integer[] cur = Q.poll();
			
			for(int d=0;d<4;d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if(nr<0||nc<0||nr>=N||nc>=M) continue;				
				if(cur[2] == 0) { // 한번도 안깸
					if(map[nr][nc] == 1) {
						// 한번도 안깼는데 벽을 만남 -> 깨고 가자
						if(dist2[nr][nc] != 0) continue;
						dist2[nr][nc] = dist1[cur[0]][cur[1]] + 1;
						Q.offer(new Integer[] {nr,nc,1});
					} else {
						// 벽을 안만남 -> 그냥 가자
						if(dist1[nr][nc] != 0) continue;
						dist1[nr][nc] = dist1[cur[0]][cur[1]] + 1;
						Q.offer(new Integer[] {nr,nc,0});
					}
				} else { // 기회 소멸
					if(map[nr][nc] == 1) continue;
					if(dist2[nr][nc] != 0) continue;
					dist2[nr][nc] = dist2[cur[0]][cur[1]] + 1;
					Q.offer(new Integer[] {nr,nc,1});
				}
			}
			
		}
	}

}
