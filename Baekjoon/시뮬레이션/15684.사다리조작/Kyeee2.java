import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Kyeee2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, M, H;
	static boolean [][] ladder;
	static List<Point> points = new ArrayList<>();
	
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
		H = Integer.parseInt(tokens.nextToken());
		
		ladder = new boolean [H + 1][N + 1];
		for(int i = 0; i < M; i++) {
			tokens = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			
			ladder[a][b] = true; // 오른쪽으로 이동 가능
		}
		
		for(int r = 1; r <= H; r++) {
			for(int c = 1; c < N; c++) {
				// c + 1까지 체크하는 이유는 만약 c를 이어주게 된다면 오른쪽으로 두번 움직이게 되므로!
				if(ladder[r][c - 1] || ladder[r][c] || ladder[r][c + 1]) continue;
				
				points.add(new Point(r, c));
			}
		}
		
		if(isPossible()) {
			System.out.println(0);
			return;
		}
		
		int result = 4, size = points.size();
		// 추가로 놓을 수 있는 가로선 조합으로 3개 뽑기 -> 3중 for문으로 해결
		for(int i = 0; i < size; i++) {
			ladder[points.get(i).r][points.get(i).c] = true; // 가로선 놓기
			if(isPossible()) result = Math.min(result, 1);
			for(int j = i + 1; j < size; j++) {
				ladder[points.get(j).r][points.get(j).c] = true; // 가로선 놓기
				if(isPossible()) result = Math.min(result, 2);
				for(int k = j + 1; k < size; k++) {
					ladder[points.get(k).r][points.get(k).c] = true; // 가로선 놓기
					if(isPossible()) result = Math.min(result, 3);
					ladder[points.get(k).r][points.get(k).c] = false; // 가로선 지우기				
				}
				ladder[points.get(j).r][points.get(j).c] = false; // 가로선 지우기
			}
			ladder[points.get(i).r][points.get(i).c] = false; // 가로선 지우기
		}
		
		if(result == 4) System.out.println(-1);
		else System.out.println(result);
	}
	
	private static boolean isPossible() {
		for(int c = 1; c <= N; c++) {
			int now = c;
			
			for(int r = 1; r <= H; r++) {
				if(ladder[r][now - 1]) now--; // 왼쪽으로 이동
				else if(ladder[r][now]) now++; // 오른쪽으로 이동
			}
			
			if(now != c) return false;
		}
		
		return true;
	}
	
}
