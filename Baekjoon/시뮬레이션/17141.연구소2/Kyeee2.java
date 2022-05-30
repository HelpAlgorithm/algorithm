import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Kyeee2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, M, result = Integer.MAX_VALUE;
	static int [][] map;
	static List<Point> virus;
	static Queue<Point> Q;
	static int [] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
	
	static class Point {
		int r, c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		map = new int [N][N];
		virus = new ArrayList<>();
		for(int r = 0; r < N; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
				
				if(map[r][c] == 2) {
					map[r][c] = 0;
					virus.add(new Point(r, c));
				} 
				if(map[r][c] == 1) {
					map[r][c] = -1; // 벽은 -1로 표시
				}
			}
		}
		
		comb(0, 0);
		if(result == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(result);
	}

	private static void comb(int start, int cnt) {
		if(cnt == M) {
			result = Math.min(result, countTime());
			return;
		}
		
		for(int i = start; i < virus.size(); i++) {
			map[virus.get(i).r][virus.get(i).c] = 2;
			comb(i + 1, cnt + 1);
			map[virus.get(i).r][virus.get(i).c] = 0;
		}
	}

	private static int countTime() {
		int [][] time = new int [N][N];
		Q = new LinkedList<>();

		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(map[r][c] == 2) {
					Q.offer(new Point(r, c));
				}
			}
		}
		
		while(!Q.isEmpty()) {
			Point now = Q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nr = now.r + dr[i];
				int nc = now.c + dc[i];
				
				// 인덱스를 벗어나거나 빈칸이 아닌 경우
				if(nr < 0 || nr >= N || nc < 0 || nc >= N ) continue;
				if(map[nr][nc] != 0 || time[nr][nc] != 0) continue;
				
				Q.offer(new Point(nr, nc));
				time[nr][nc] = time[now.r][now.c]+ 1; 
			}
		}
		
		int maxTime = 0;
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				// 벽인경우
				if(map[r][c] == -1) continue;
				
				// 바이러스가 다 퍼지지 못한 경우
				if(time[r][c] == 0 && map[r][c] == 0) {
					return Integer.MAX_VALUE;
				}
				
				maxTime = Math.max(maxTime, time[r][c]);
			}
		}
		
		return maxTime;
	}

}
