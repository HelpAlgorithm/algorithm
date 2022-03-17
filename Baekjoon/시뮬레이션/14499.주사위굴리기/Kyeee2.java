import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Kyeee2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N, M, nowR, nowC, K;
	static int [][] map;
	static int [] dice = new int [7]; // 1부터 시작
	static int [] dr = {0, 0, -1, 1}, dc = {1, -1, 0, 0}; // 동, 서, 북, 남

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		nowR = Integer.parseInt(tokens.nextToken());
		nowC = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		
		// 지도 세팅
		map = new int [N][M];
		for(int r = 0; r < N; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		// K번 이동
		tokens = new StringTokenizer(br.readLine());
		for(int k = 0; k < K; k++) {
			int dir = Integer.parseInt(tokens.nextToken()) - 1; // 방향

			// 다음 이동 좌표
			int nr = nowR + dr[dir];
			int nc = nowC + dc[dir];
			
			// 지도 밖으로 넘어가는 경우
			if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
			
			changeDice(dir);
			if(map[nr][nc] == 0) map[nr][nc] = dice[6];
			else {
				dice[6] = map[nr][nc];
				map[nr][nc] = 0;
			}
			
			nowR = nr;
			nowC = nc;
			
			output.append(dice[1] + "\n");
		}
		System.out.println(output);
	}

	private static void changeDice(int dir) {
		int temp = 0;
		switch(dir) {
		case 0: // 동
			temp = dice[1];
			dice[1] = dice[4];
			dice[4] = dice[6];
			dice[6] = dice[3];
			dice[3] = temp;
			break;
		case 1: // 서
			temp = dice[1];
			dice[1] = dice[3];
			dice[3] = dice[6];
			dice[6] = dice[4];
			dice[4] = temp;
			break;
		case 2: // 북
			temp = dice[2];
			dice[2] = dice[1];
			dice[1] = dice[5];
			dice[5] = dice[6];
			dice[6] = temp;
			break;
		case 3: // 남
			temp = dice[6];
			dice[6] = dice[5];
			dice[5] = dice[1];
			dice[1] = dice[2];
			dice[2] = temp;
			break;
		}
		
	}

}
