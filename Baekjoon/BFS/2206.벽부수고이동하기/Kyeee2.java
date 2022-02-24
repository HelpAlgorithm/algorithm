import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Kyeee2 {
	
	// 참고 블로그
	// https://velog.io/@yanghl98/%EB%B0%B1%EC%A4%80-2206-%EB%B2%BD-%EB%B6%80%EC%88%98%EA%B3%A0-%EC%9D%B4%EB%8F%99%ED%95%98%EA%B8%B0-JAVA%EC%9E%90%EB%B0%94

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, M;
	static boolean [][] map;
	static boolean [][][] visited;
	static int [] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
	
	static class Point {
		int r, c, cnt;
		boolean distroyed; // 파괴한적이 있는가?
		
		public Point(int r, int c, int cnt, boolean distroyed) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.distroyed = distroyed;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		map = new boolean[N][M]; 
		visited = new boolean[N][M][2]; // 마지막 차원 -> 0: 부순적 x, 1: 부순적 o 
		for(int r = 0; r < N; r++) {
			String line = br.readLine();
			for(int c = 0; c < M; c++) {
				if(line.charAt(c) == '0') {
					map[r][c] = true;
				}
			}
		}
		
		Queue<Point> Q = new LinkedList<>();
		Q.offer(new Point(0, 0, 1, false)); // 0, 0 위치 넣기
		visited[0][0][0] = true;
		
		while(!Q.isEmpty()) {
			Point p = Q.poll();
			
			// 목적지 도착
			if(p.r == N - 1 && p.c == M - 1) {
				System.out.println(p.cnt);
				return;
			}
			
			for(int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				int ncnt = p.cnt + 1;
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue; // 인덱스 벗어남
				if(map[nr][nc] == false && p.distroyed) continue; // 벽을 만났는데 이미 부순 후라면
				
				if(map[nr][nc]) { // 벽이 아니라면
					if(!p.distroyed && !visited[nr][nc][0]) {
						Q.offer(new Point(nr, nc, p.cnt + 1, false));
						visited[nr][nc][0] = true;
					} else if(p.distroyed && !visited[nr][nc][1]) {
						Q.offer(new Point(nr, nc, p.cnt + 1, true));
						visited[nr][nc][1] = true;
					}
				} else { // 벽이라면
					if(!p.distroyed) {
						Q.offer(new Point(nr, nc, p.cnt + 1, true));
						visited[nr][nc][1] = true;
					}
				}
				
			}
		}
		
		// 끝까지 가지 못한 경우
		System.out.println("-1");

	}
	
	

}
