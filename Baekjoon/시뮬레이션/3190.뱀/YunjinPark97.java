package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon3190_뱀 {
	static int N, dir;
	static int[][] map;
	static char[] dirs;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int r = 0, c = 0;
	static Queue<int[]> snake = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 1;
		}
		
		dirs = new char[10001];
		int L = Integer.parseInt(br.readLine());
		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			dirs[Integer.parseInt(st.nextToken())] = st.nextToken().charAt(0);
		}
		
		dir = 1; // 0: 북, 1: 동, 2: 남, 3: 서
		int t = 0;
		snake.offer(new int[] {r, c});
		map[r][c] = 2;
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		while (canMove(t)) {
//			System.out.println("r:"+r+", c:"+c);
			t++;
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
//			System.out.println("_____________________________");
		}
		
		System.out.println(t+1); // 몸에 박기 전, 벽에 박기 전 1초 더 갈 수 있음.
	}
	
	
	static boolean canMove(int time) {
		if (dirs[time] == 'L') dir = (dir + 3) % 4;
		if (dirs[time] == 'D') dir = (dir + 1) % 4;
		int nr = r + dr[dir];
		int nc = c + dc[dir];
		if (nr < 0 || nr >= N || nc < 0 || nc >= N) return false;
	
		
		// 연속적으로 스르륵 도는건 안 됨(예제 2와 3의 차이)
		if (map[nr][nc] == 2) return false;
		
		if (map[nr][nc] != 1) {
			int[] snakeTail = snake.poll();
			map[snakeTail[0]][snakeTail[1]] = 0;
		}
		r = nr;
		c = nc;		
		snake.offer(new int[] {r, c});
		map[r][c] = 2;
		return true;
	}

}








