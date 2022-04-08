import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1}; 
	static int[][] lab;
	static int M, N, ans;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		lab = new int[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				lab[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ans = 0;
		comb(0, 0);
		System.out.println(ans);
	}
	
	static void comb(int cnt, int rowAndCol) {
		if (cnt == 3) {
			int temp = 0;
			visited = new boolean[M][N];
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j] && lab[i][j] == 2) {
						bfs(i, j);
					}
				}
			}
			
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (lab[i][j] == 0 && !visited[i][j]) temp++;
				}
			}
			
			if (temp > ans) {
				ans = temp;
			}
			return;
		}
				
		
		for (int i = rowAndCol; i < M*N; i++) {
			int row = i/N, col = i%N;
			if (lab[row][col] == 0) {
				lab[row][col] = 1;
				comb(cnt+1, i+1);
				lab[row][col] = 0;
			}
		}
	}
	

	static void bfs(int i, int j) {
		Queue<int[]> queue = new ArrayDeque<>();
		visited[i][j] = true;
		queue.offer(new int[] {i, j});
		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			int r = temp[0], c = temp[1];
			for (int dir = 0; dir < 4; dir++) {
				int nr = r + dr[dir], nc = c + dc[dir];
				if (nr < 0 || nr >= M || nc < 0 || nc >= N) continue;
				if (visited[nr][nc] || lab[nr][nc] == 1) continue;
				visited[nr][nc] = true;
				queue.offer(new int[] {nr, nc});
			}
		}
	}
}
























