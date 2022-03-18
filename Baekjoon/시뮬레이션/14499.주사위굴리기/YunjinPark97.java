package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon14499_주사위굴리기 {
	static int[][] dice; // 문제처럼 주사위 쓰기
	// 0,1: 주사위 뒷면, 1,0: 주사위 왼쪽 옆면, 1,1: 주사위 위쪽 면, 1,2: 주사위 오른쪽 옆면 2,1: 주사위 앞쪽 면, 3,1: 주사위 바닥면
	static int[][] map;
	static int diceRow, diceCol;
	static int M, N;
	static boolean isRoll;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		dice = new int[4][3];
		map = new int[M][N];
		diceRow = Integer.parseInt(st.nextToken());
		diceCol = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for (int k = 0; k < K; k++) {
			isRoll = false;
			int dir = Integer.parseInt(st.nextToken());
			roll(dir);
			
			
			if (!isRoll) continue;
			copy();
			System.out.println(dice[1][1]);
			
//			for (int i = 0; i < 4; i++) {
//				System.out.println(Arrays.toString(dice[i]));
//			}
//			System.out.println("__________________");
		}
	}
	
	
	static void copy() {
		if (map[diceRow][diceCol] == 0) {
			map[diceRow][diceCol] = dice[3][1];
		}
		else {
			dice[3][1] = map[diceRow][diceCol];
			map[diceRow][diceCol] = 0;
		}
	}
	
	
	static void roll(int dir) {
		int temp;
		
		switch (dir) {
		case 1:
			if (diceCol + 1 >= N) break;
			isRoll = true;
			diceCol++;
			temp = dice[3][1];
			dice[3][1] = dice[1][2];
			dice[1][2] = dice[1][1];
			dice[1][1] = dice[1][0];
			dice[1][0] = temp;
			break;
			
		case 2:
			if (diceCol - 1 < 0) break;
			isRoll = true;
			diceCol--;
			temp = dice[1][1];
			dice[1][1] = dice[1][2];
			dice[1][2] = dice[3][1];
			dice[3][1] = dice[1][0];
			dice[1][0] = temp;
			break;

		case 3:
			if (diceRow -1 < 0) break;
			isRoll = true;
			diceRow--;
			temp = dice[1][1];
			dice[1][1] = dice[2][1];
			dice[2][1] = dice[3][1];
			dice[3][1] = dice[0][1];
			dice[0][1] = temp;
			break;
			
		case 4:
			if (diceRow + 1 >= M) break;
			isRoll = true;
			diceRow++;
			temp = dice[3][1];
			dice[3][1] = dice[2][1];
			dice[2][1] = dice[1][1];
			dice[1][1] = dice[0][1];
			dice[0][1] = temp;
			break;
		}
	}
}









