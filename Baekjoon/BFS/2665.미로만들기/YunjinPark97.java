import java.io.*;
import java.util.*;

public class Main {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		int[][] dist = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(dist[i], 1000);
		}
		
		PriorityQueue<Loc> pq = new PriorityQueue<>();
		pq.offer(new Loc(0, 0, 0));
		dist[0][0] = 0;
		while (!pq.isEmpty()) {
			Loc cur = pq.poll();
			int r = cur.row, c = cur.col, cnt = cur.cnt;
			if (dist[r][c] < cnt) continue;
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i], nc = c + dc[i];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				int ncnt = (map[nr][nc] == 0)? cnt+1: cnt;
				if (dist[nr][nc] <= ncnt) continue;
				dist[nr][nc] = ncnt;
				pq.offer(new Loc(nr, nc, ncnt));
			}
		}
		System.out.println(dist[N-1][N-1]);
	}

	static class Loc implements Comparable<Loc>{
		int row;
		int col;
		int cnt;
		
		public Loc(int row, int col, int cnt) {
			this.row = row;
			this.col = col;
			this.cnt = cnt;
		}
		
		public int compareTo(Loc o) {
			return Integer.compare(this.cnt, o.cnt);
		}
	}
}
