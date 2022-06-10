import java.io.*;
import java.util.*;

public class Kyeee2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, total, minDiff = Integer.MAX_VALUE;
	static int [][] A;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		A = new int [N + 1][N + 1];
		for(int r = 1; r <= N; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(int c = 1; c <= N; c++) {
				A[r][c] = Integer.parseInt(tokens.nextToken());
				total += A[r][c];
			}
		}
		
		for(int x = 1; x <= N; x++) {
			for(int y = 1; y <= N; y++) {
				for(int d1 = 1; ; d1++) {
					if(y - d1 < 1) break;
					for(int d2 = 1; ; d2++) {
						if(x + d1 + d2 > N || y + d2 > N) break;
						calcSub(x, y, d1, d2);
					}
				}
			}
		}
		
		System.out.println(minDiff);
	}

	private static void calcSub(int x, int y, int d1, int d2) {
		int [][] temp = new int [N + 1][N + 1];
		int max = -1;
		int min = Integer.MAX_VALUE;
		int area5 = total;
		
		// 1번 선거구역
		int sum = 0;
		for(int r = 1, C = y; r < x + d1; r++) {
			if(r >= x) {
				C--;
			}
			for(int c = 1; c <= C; c++) {
				temp[r][c] = 1;
				sum += A[r][c];
			}
		}
		max = Math.max(max, sum);
		min = Math.min(min, sum);
		area5 -= sum;
		
		// 2번 선거구역
		sum = 0;
		for(int c = N, R = x + d2; c > y; c--) {
			if(c <= y + d2) {
				R--;
			}
			for(int r = 1; r <= R; r++) {
				temp[r][c] = 2;
				sum += A[r][c];
			}
		}
		max = Math.max(max, sum);
		min = Math.min(min, sum);
		area5 -= sum;
		
		// 3번 선거구역
		sum = 0;
		for(int c = 1, R = x + d1; c < y - d1 + d2; c++) {
			if(c >= y - d1) {
				R++;
			}
			for(int r = R; r <= N; r++) {
				temp[r][c] = 3;
				sum += A[r][c];
			}
		}
		max = Math.max(max, sum);
		min = Math.min(min, sum);
		area5 -= sum;
		
		// 4번 선거구역
		sum = 0;
		for(int r = N, C = y - d1 + d2; r > x + d2; r--) {
			if(r <= x + d1 + d2) {
				C++;
			}
			for(int c = C; c <= N; c++) {
				temp[r][c] = 4;
				sum += A[r][c];
			}
		}
		max = Math.max(max, sum);
		min = Math.min(min, sum);
		area5 -= sum;
		
		// 5번 선거구역
		max = Math.max(max, area5);
		min = Math.min(min, area5);
		
		minDiff = Math.min(minDiff, max - min);
		
	}

}
