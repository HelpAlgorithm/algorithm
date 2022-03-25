package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import boj.g5.BOJ_G5_3190_뱀.Snake;

public class 백준_G5_3190_뱀 {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Snake {
		int r, c;

		public Snake(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Snake [r=" + r + ", c=" + c + "]";
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());

		int[][] map = new int[N + 1][N + 1];

		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			map[r][c] = 2;
		}

		int L = Integer.parseInt(br.readLine());

		Queue<String[]> moves = new LinkedList<>();
		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			moves.offer(new String[] { st.nextToken(), st.nextToken() });
		}

		int dir = 3;
		int nr = 1, nc = 1;
		int time = 0;
		int size = 1;
		map[nr][nc] = 1;

		Queue<Snake> snake = new LinkedList<>();
		snake.add(new Snake(1, 1));
		while (true) {
			if (!moves.isEmpty()) {
				if (time == Integer.parseInt(moves.peek()[0])) {
					dir = nextDir(dir, moves.peek()[1].charAt(0));
					moves.poll();
				}
			}

			nr += dr[dir];
			nc += dc[dir];

			if (nr < 1 || nc < 1 || nr > N || nc > N || map[nr][nc] == 1) {
				System.out.println(time + 1);
				return;
			}

			if (map[nr][nc] == 2) {
				map[nr][nc] = 1;
				size++;
			} else {
				map[nr][nc] = 1;
				Snake tail = snake.poll();
				map[tail.r][tail.c] = 0;
			}
			snake.offer(new Snake(nr, nc));
			time++;
		}

	}

	private static int nextDir(int curDir, char c) {
		if (curDir == 0) {
			if (c == 'L') {
				return 2;
			} else {
				return 3;
			}
		} else if (curDir == 1) {
			if (c == 'L') {
				return 3;
			} else {
				return 2;
			}
		} else if (curDir == 2) {
			if (c == 'L') {
				return 1;
			} else {
				return 0;
			}
		} else {
			if (c == 'L') {
				return 0;
			} else {
				return 1;
			}
		}
	}
}