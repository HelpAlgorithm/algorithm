import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Chiyongs {

	static class Dice {
		int a, b, c, d, e, f;		
	}

	static int row, col, N, M, map[][];
	static Dice dice = new Dice();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < K; i++) {
			int dir = Integer.parseInt(st.nextToken());
			int temp_r = row, temp_c = col;

			moveDice(row, col, dir);
			if(temp_r == row && temp_c == col) {
				// 이동이 제대로 이루어지지 않았을 때 (범위밖으로 나갔을때)
			} else {				
				sb.append(dice.f).append("\n");
			}
		}
		
		System.out.println(sb.toString());

	}

	private static boolean isIn(int r, int c) {
		if (r < 0 || c < 0 || r >= N || c >= M)
			return false;
		else
			return true;
	}

	private static void moveDice(int r, int c, int dir) {
		if (dir == 1) {
			// 동쪽
			int nr = r;
			int nc = c + 1;

			if (isIn(nr, nc)) {
				int value = map[nr][nc];
				if (value != 0) {
					Dice temp = new Dice();

					temp.a = dice.a;
					temp.b = dice.c;
					temp.c = dice.d;
					temp.d = dice.f;
					temp.e = dice.e;
					temp.f = dice.b;

					temp.c = value;

					dice = temp;

					map[nr][nc] = 0;
				} else {
					Dice temp = new Dice();

					temp.a = dice.a;
					temp.b = dice.c;
					temp.c = dice.d;
					temp.d = dice.f;
					temp.e = dice.e;
					temp.f = dice.b;

					map[nr][nc] = temp.c;

					dice = temp;
				}
				row = nr;
				col = nc;
			}

		} else if (dir == 2) {
			// 서쪽
			int nr = r;
			int nc = c - 1;

			if (isIn(nr, nc)) {
				int value = map[nr][nc];
				if (value != 0) {
					Dice temp = new Dice();

					temp.a = dice.a;
					temp.b = dice.f;
					temp.c = dice.b;
					temp.d = dice.c;
					temp.e = dice.e;
					temp.f = dice.d;

					temp.c = value;

					dice = temp;
					map[nr][nc] = 0;
				} else {
					Dice temp = new Dice();

					temp.a = dice.a;
					temp.b = dice.f;
					temp.c = dice.b;
					temp.d = dice.c;
					temp.e = dice.e;
					temp.f = dice.d;

					map[nr][nc] = temp.c;

					dice = temp;
				}
				row = nr;
				col = nc;
			}
		} else if (dir == 3) {
			// 북쪽
			int nr = r - 1;
			int nc = c;

			if (isIn(nr, nc)) {
				int value = map[nr][nc];
				if (value != 0) {
					Dice temp = new Dice();

					temp.a = dice.f;
					temp.b = dice.b;
					temp.c = dice.a;
					temp.d = dice.d;
					temp.e = dice.c;
					temp.f = dice.e;

					temp.c = value;

					dice = temp;
					map[nr][nc] = 0;
				} else {
					Dice temp = new Dice();

					temp.a = dice.f;
					temp.b = dice.b;
					temp.c = dice.a;
					temp.d = dice.d;
					temp.e = dice.c;
					temp.f = dice.e;

					map[nr][nc] = temp.c;

					dice = temp;
				}
				row = nr;
				col = nc;
			}
		} else if (dir == 4) {
			// 남쪽
			int nr = r + 1;
			int nc = c;

			if (isIn(nr, nc)) {
				int value = map[nr][nc];
				if (value != 0) {
					Dice temp = new Dice();

					temp.a = dice.c;
					temp.b = dice.b;
					temp.c = dice.e;
					temp.d = dice.d;
					temp.e = dice.f;
					temp.f = dice.a;
					temp.c = value;
					
					dice = temp;
					map[nr][nc] = 0;
					
				} else {
					Dice temp = new Dice();

					temp.a = dice.c;
					temp.b = dice.b;
					temp.c = dice.e;
					temp.d = dice.d;
					temp.e = dice.f;
					temp.f = dice.a;

					map[nr][nc] = temp.c;
					dice = temp;
				}
				row = nr;
				col = nc;
			}
		}
	}

}
