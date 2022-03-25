import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Kyeee2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, K, L, dir, time;
	static int [][] map;
	static String [][] dirs;
	static int [] dr = {0, 1, 0, -1}, dc = {1, 0, -1, 0};
	static List<Point> snake = new LinkedList<>();
	
	static class Point {
		int r, c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		map = new int [N + 1][N + 1];
		// 사과 위치
		K = Integer.parseInt(br.readLine());
		for(int i = 0; i < K; i++) {
			tokens = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(tokens.nextToken());
			int c = Integer.parseInt(tokens.nextToken());
			map[r][c] = 1; // 사과 놓기
		}
		
		// 뱀 방향 변환 정보
		L = Integer.parseInt(br.readLine());
		dirs = new String [L][2];
		for(int i = 0; i < L; i++) {
			tokens = new StringTokenizer(br.readLine());
			String t = tokens.nextToken();
			String d = tokens.nextToken();
			dirs[i][0] = t;
			dirs[i][1] = d;
		}
		
		// 뱀 초기 위치 설정
		snake.add(new Point(1, 1));
		map[1][1] = -1;
		dir = 0; // 현재 방향 정보
		
		int idx = 0; // 방향전환정보 인덱스
		time = 0;
		while(true) {
			time++;
			// 리스트이 마지막이 머리 처음이 꼬리 (역순)
			int nr = snake.get(snake.size() - 1).r + dr[dir];
			int nc = snake.get(snake.size() - 1).c + dc[dir];
			
			if(nr <= 0 || nr > N || nc <= 0 || nc > N || map[nr][nc] == -1) break; // 벽 또는 몸에 부딪힌 경우 종료

			if(map[nr][nc] == 1) { 
				map[nr][nc] = 0; // 사과 먹기
			} else {
				// 사과 없는 경우 꼬리 자르기
				map[snake.get(0).r][snake.get(0).c] = 0;
				snake.remove(0);
			}
			
			snake.add(new Point(nr, nc)); // 머리 늘리기
			map[nr][nc] = -1;
			
			if(idx < L && Integer.parseInt(dirs[idx][0]) == time) {
				// 방향 바꿔주기
				if(dirs[idx][1].charAt(0) == 'D') { // 오른쪽으로
					dir = (dir + 1) % 4;
				} else { // 왼쪽으로
					dir = (dir + 3) % 4;
				}
				idx++;
			}
		}
		
		System.out.println(time);
	}

}
