import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Kyeee2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, M, max = -1;
	static int [][] map;
	static boolean [][] visited;
	static int [] result = new int [3];
	static int [] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
	static List<Point> blanks = new ArrayList<>();
	
	static class Point {
		int r , c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		map = new int [N][M];
		for(int r = 0; r < N; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
				if(map[r][c] == 0) blanks.add(new Point(r, c));
			}
		}
		
		comb(0, 0, 0);
		
		System.out.println(max);
	}

	// 벽 3개를 세우기 위해 빈칸들 중 3개 뽑는 조합
	private static void comb(int cnt, int start, int bits) {
		if(cnt == 3) {
			for(int i = 0; i < 3; i++) {
				map[blanks.get(result[i]).r][blanks.get(result[i]).c] = 1; // 벽으로 바꿔주기
			}
			max = Math.max(max, bfs());
			for(int i = 0; i < 3; i++) {
				map[blanks.get(result[i]).r][blanks.get(result[i]).c] = 0; // 벽으로 바꿔주기
			}
			return;
		}
		
		for(int i = start; i < blanks.size(); i++) {
			if((bits & 1 << i) != 0) continue;
			
			result[cnt] = i;
			comb(cnt + 1, i + 1, bits | 1 << i);
		}
	}

	// 바이러스가 퍼지지 않는 영역 개수 찾기
	private static int bfs() {
		Queue<Point> Q = new LinkedList<>();
		visited = new boolean [N][M];
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(map[r][c] == 2) {
					Q.add(new Point(r, c));
					visited[r][c] = true;
					
					while(!Q.isEmpty()) {
						Point now = Q.poll();
						
						for(int i = 0; i < 4; i++) {
							int nr = now.r + dr[i];
							int nc = now.c + dc[i];
							
							if(nr < 0 | nr >= N || nc < 0 || nc >= M || visited[nr][nc] || map[nr][nc] == 1) continue;
							
							Q.add(new Point(nr, nc));
							visited[nr][nc] = true;
						}
					}
				}
			}
		}
		
		int cnt = 0;
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(map[r][c] == 0 && !visited[r][c]) cnt++;
			}
		}
		
		return cnt;
	}

}
