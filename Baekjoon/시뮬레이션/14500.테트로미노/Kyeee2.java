import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Kyeee2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, M, max = -1;
	static int [][] map;
	static boolean [][] visited;
	static int [] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
	static int [][] sr = {{0, 0, 1, 0}, {0, -1, 0, 1}, {0, 0, -1, 0}, {0, 1, 0, -1}}, 
			        sc = {{0, 1, 0, -1}, {0, 0, 1, 0}, {0, -1, 0, 1}, {0, 0, -1, 0}}; // ㅜ, ㅏ, ㅗ, ㅓ 모양
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		map = new int [N][M];
		visited = new boolean [N][M];
		for(int r = 0; r < N; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				// ㅜ 모양을 제외한 모양들의 최댓값 찾기 (DFS사용)
				visited[r][c] = true;
				dfs(r, c, map[r][c], 1);
				visited[r][c] = false;
				
				// ㅜ 모양의 최댓값 찾기 (구현)
				findMax(r, c);
			}
		}
		
		System.out.println(max);
	}

	private static void dfs(int r, int c, int sum, int cnt) {
		if(cnt == 4) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) continue;
			
			visited[nr][nc] = true;
			dfs(nr, nc, sum + map[nr][nc], cnt + 1);
			visited[nr][nc] = false;
		}
 	}
	
	private static void findMax(int r, int c) {
		for(int i = 0; i < 4; i++) {
			boolean isOut = false;
			int sum = 0;
			for(int j = 0; j < 4; j++) {
				int nr = r + sr[i][j];
				int nc = c + sc[i][j];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M) {
					isOut = true;
					break;
				}
				
				sum += map[nr][nc];
			}
			
			if(!isOut)	max = Math.max(max, sum);
		}
	}

}
