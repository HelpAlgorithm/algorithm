import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Kyeee2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, L, cnt;
	static int [][] map;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		L = Integer.parseInt(tokens.nextToken());
		
		map = new int [N][N];
		for(int r = 0; r < N; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		for(int r = 0; r < N; r++) {
			// 행 방향 탐색			
			if(isPossible(map[r])) cnt++;
			
			// 열 방향 탐색
			int [] temp = new int [N];
			for(int i = 0; i < N; i++) {
				temp[i] = map[i][r];
			}
			if(isPossible(temp)) cnt++;
		}
		System.out.println(cnt);
	}

	private static boolean isPossible(int[] row) {
		boolean [] checked = new boolean [N];
		
		for(int idx = 1; idx < N; idx++) {
			if(checked[idx] || row[idx] == row[idx - 1]) continue; // 높이가 같으면 통과
			if(Math.abs(row[idx] - row[idx - 1]) > 1) return false; // 높이의 차가 1보다 크면 실패

			if(row[idx] + 1 == row[idx - 1]) {
				if(idx + L - 1 >= N || checked[idx + L - 1]) return false;
				for(int i = idx; i < idx + L; i++) {
					if(checked[i] || row[idx] != row[i]) return false;
					
					checked[i] = true;
				}
			} else if(row[idx] == row[idx - 1] + 1) {
				if(idx - L < 0 || checked[idx - L]) return false;
				for(int i = idx - 1; i >= idx - L; i--) {
					if(checked[i] || row[idx - 1] != row[i]) return false;
					
					checked[i] = true;
				}
			}
		}
		
		return true;
	}

}
