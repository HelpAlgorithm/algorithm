import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Kyeee2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int [][] gears = new int [5][8];
	static boolean [] visited;
	static int K;
	
	public static void main(String[] args) throws IOException {
		// 기어 상태 입력
		for(int i = 1; i <= 4; i++) {
			String line = br.readLine();
			
			for(int j = 0; j < 8; j++) {
				gears[i][j] = line.charAt(j) - '0';
			}
		}
		
		K = Integer.parseInt(br.readLine());
		for(int i = 0; i < K; i++) {
			tokens = new StringTokenizer(br.readLine());
			
			int gear = Integer.parseInt(tokens.nextToken()); // 회전시킨 톱니바퀴 번호
			int dir = Integer.parseInt(tokens.nextToken());  // 방향
			
			visited = new boolean[5];
			rotate(gear, dir);
		}
		
		int sum = 0;
		for(int i = 1; i <= 4; i++) {
			sum += gears[i][0] * (1 << (i - 1));
		}
		System.out.println(sum);
	}

	private static void rotate(int gear, int dir) {
		visited[gear] = true;
		
		// 왼쪽 톱니바퀴 회전 여부 판단
		if(gear > 1 && !visited[gear - 1] && gears[gear][6] != gears[gear - 1][2]) {
			// 맞닿은 톱니의 극이 다르다면
			rotate(gear - 1, dir * -1);
		}
		
		// 오른쪽 톱니바퀴 회전 여부 판단
		if(gear < 4 && !visited[gear + 1] && gears[gear][2] != gears[gear + 1][6]) {
			// 맞닿은 톱니의 극이 다르다면
			rotate(gear + 1, dir * -1);
		}
		
		if(dir == 1) {
			// 시계방향 회전
			int temp = gears[gear][7];
			for(int i = 6; i >= 0; i--) {
				gears[gear][i + 1] = gears[gear][i];
			}
			gears[gear][0] = temp;
		} else if(dir == -1) {
			// 반시계방향 회전
			int temp = gears[gear][0];
			for(int i = 0; i < 7; i++) {
				gears[gear][i] = gears[gear][i + 1];
			}
			gears[gear][7] = temp;
		}
	}

}
