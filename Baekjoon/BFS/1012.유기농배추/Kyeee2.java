import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Kyeee2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int T, N, M, K, cnt;
	static boolean [][] map;
	static Queue<Point> Q;
	static int [] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
	
	static class Point {
		int r, c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			tokens = new StringTokenizer(br.readLine());
			M = Integer.parseInt(tokens.nextToken());
			N = Integer.parseInt(tokens.nextToken());
			K = Integer.parseInt(tokens.nextToken());
			
			map = new boolean [N][M];
			for(int i = 0; i < K; i++) {
				tokens = new StringTokenizer(br.readLine());
				
				int c = Integer.parseInt(tokens.nextToken());
				int r = Integer.parseInt(tokens.nextToken());
				map[r][c] = true;
			}
			
			Q = new LinkedList<>();
			cnt = 0; // 배추벌레 개수
			
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < M; c++) {
					if(map[r][c]) { // 배추가 심어져 있다면
						
						BFS(r, c);
					}
				}
			}
			
			output.append(cnt).append('\n');
		}
		System.out.println(output);
	}

	private static void BFS(int r, int c) {	
		Q.offer(new Point(r, c));
		map[r][c] = false;
		cnt++;
		
		while(!Q.isEmpty()) {
			Point p = Q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nr = p.r + dx[i];
				int nc = p.c + dy[i];
				
				if(isIn(nr, nc) && map[nr][nc]) {
					Q.offer(new Point(nr, nc));
					map[nr][nc] = false;
				}
			}
		}
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

}
