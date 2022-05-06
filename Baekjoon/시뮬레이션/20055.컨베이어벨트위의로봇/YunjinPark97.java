package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon20055_컨베이어벨트위의로봇 {
	
	static boolean[] robots;
	static int[] belt;
	static int N, K, count, time = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		robots = new boolean[N];
		belt = new int[2*N];
		count = 0;
		
		for (int i = 0; i < 2*N; i++) {
			belt[i] = Integer.parseInt(st.nextToken());
			if (belt[i] == 0) count++;
		}
		
		while (true) {
			time++;
			rotate();
			move();
			place();
			if (isEnd()) break;
//			System.out.println("_______________________________________");
		}
		System.out.println(time);
	}
	
	
	static void rotate() {
		int temp = belt[2*N-1];
		for (int i = 2*N-1; i > 0; i--) {
			belt[i] = belt[i-1];
		}
		belt[0] = temp;
		
		for (int i = N-1; i > 0; i--) {
			robots[i] = robots[i-1];
		}
		robots[N-1] = false;
		robots[0] = false;
//		System.out.println(Arrays.toString(belt));
	}
	
	
	static void move() {
		for (int i = N-1; i > 0; i--) {
			if (belt[i] > 0 && !robots[i] && robots[i-1]) {
				robots[i-1] = false;
				robots[i] = true;
				if (i == N-1) robots[i] = false;
				belt[i]--;
				if (belt[i] == 0) count++;
			}
 		}
//		System.out.println(Arrays.toString(belt));
	}
	
	
	static void place() {
		if (belt[0] > 0 && !robots[0]) {
			robots[0] = true;
			belt[0] --;
			if (belt[0] == 0) count++;
		}
//		System.out.println(Arrays.toString(belt));
	}
	
	
	static boolean isEnd() {
		return count >= K;
	}
}

















