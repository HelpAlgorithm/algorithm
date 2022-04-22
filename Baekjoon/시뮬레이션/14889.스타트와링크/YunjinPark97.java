package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon14889_스타트와링크 {
	static int N;
	static int[][] map;
	static int ans = Integer.MAX_VALUE;
	static int[] choice;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		choice = new int[N/2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		comb(0, 0);
		System.out.println(ans);
	}

	
	static void comb(int cnt, int start) {
		if (cnt == N/2) {
			int[] notChoice = new int[N/2];
			int idx1 = 0, idx2 = 0;
			for (int i = 0; i < N; i++) {
				if (idx1 < N/2 && choice[idx1] == i) {
					idx1++;
				} else {
					notChoice[idx2++] = i;
				}
			}
			int sum1 = 0, sum2 = 0;
			
			for (int player1: choice) {
				for (int player2: choice) {
					sum1 += map[player1][player2];
				}
			}
			for (int player1: notChoice) {
				for (int player2: notChoice) {
					sum2 += map[player1][player2];
				}
			}
			ans = Math.min(ans, Math.abs(sum1 - sum2));
			return;
		}
		
		for (int i = start; i < N; i++) {
			choice[cnt] = i;
			comb(cnt+1, i+1);
		}
	}
}



























