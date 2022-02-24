package boj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 2. 24.
 * @see https://www.acmicpc.net/problem/1012
 * @performance 13656	120
 * @category #BFS
 * @note
 */
public class Chiyongs {
	
	static boolean[][] visited;
	static int N,M,K,farm[][];
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			farm = new int[N][M];
			visited = new boolean[N][M];
			
			for(int k=0;k<K;k++) {
				st = new StringTokenizer(br.readLine()," ");
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				farm[Y][X] = 1;
			}
			
			int cnt = 0;
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(!visited[i][j] && farm[i][j] == 1) {
						bfs(new Integer[] {i,j});
						cnt++;
					}
				}
			}
			
			sb.append(cnt).append("\n");
		}
		
		System.out.println(sb.toString());

	}
	
	private static void bfs(Integer[] start) {
		Queue<Integer[]> Q = new LinkedList<>();
		Q.offer(start);
		visited[start[0]][start[1]] = true;
		
		while(!Q.isEmpty()) {
			Integer[] cur = Q.poll();
			
			for(int d=0;d<4;d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if(nr<0||nc<0||nr>=N||nc>=M) continue;
				if(visited[nr][nc] || farm[nr][nc] == 0) continue;
				
				visited[nr][nc] = true;
				Q.offer(new Integer[] {nr,nc});
			}
		}
	}

}
