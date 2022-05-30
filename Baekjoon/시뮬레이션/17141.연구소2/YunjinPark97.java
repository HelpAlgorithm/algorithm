import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon17141_연구소2 {

	static int N, M, ans = Integer.MAX_VALUE;
	static int[][] lab, loc, choice;
	static int zeroCnt = 0;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	// 2500 * 10C5 == 252 * 2500 < 1_000_000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		lab = new int[N][N];
		choice = new int[M][2];
		int twoCnt = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				lab[i][j] = Integer.parseInt(st.nextToken());
				if (lab[i][j] == 2) twoCnt++;
				else if (lab[i][j] == 0) zeroCnt++;
			}
		}
		zeroCnt += twoCnt;
		loc = new int[twoCnt][2];
		int idx = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (lab[i][j] == 2) {
					loc[idx][0] = i;
					loc[idx++][1] = j;
				}
			}
		}
		
		comb(0, 0);
		System.out.println((ans == Integer.MAX_VALUE)? -1: ans);
	}
	
	
	static void comb(int start, int cnt) {
		if (cnt == M) {
			bfs();
			return;
		}
		
		for (int i = start; i < loc.length; i++) {
			choice[cnt][0] = loc[i][0];
			choice[cnt][1] = loc[i][1];
			comb(i+1, cnt+1);
		}
		
	}

	
	static void bfs() {
		int zero = zeroCnt;
		int cnt = 0;
		boolean[][] visited = new boolean[N][N];
		Queue<int[]> queue = new ArrayDeque<>();
		for (int i = 0; i < M; i++) {
			queue.offer(new int[] {choice[i][0], choice[i][1]});
			visited[choice[i][0]][choice[i][1]] = true;
			zero--;
		}
		while (!queue.isEmpty() && zero > 0) {
			int size = queue.size();
			while (size-- > 0) {
				int[] temp = queue.poll();
				int r = temp[0], c = temp[1];
				for (int i = 0; i < 4; i++) {
					int nr = r + dr[i], nc = c + dc[i];
					if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
					if (visited[nr][nc] || lab[nr][nc] == 1) continue;
					visited[nr][nc] = true;
					zero--;
					queue.offer(new int[] {nr, nc});
				}
			}
			cnt++;
		}
		
		if (zero == 0) {
			ans = Math.min(ans, cnt);
		}
	}
}










































