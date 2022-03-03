package divideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2630_색종이만들기 {
	static int[][] paper;
	static int blue = 0, white = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		paper = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		f(0, 0, 8);
		System.out.println(white);
		System.out.println(blue);
		
	}
	
	static void f(int row, int col, int size) {
		if (size == 1) {
			if (paper[row][col] == 0) white++;
			else blue++;
			return;
		}
		
		int temp = paper[row][col];
		boolean flag = true;
		outer: for (int i = row; i < row + size; i++) {
			for (int j = col; j < col+size; j++) {
				if (temp != paper[i][j]) {
					flag = false;
					break outer;
				}
			}
		}
		
		if (flag) {
			if (temp == 0) white++;
			else blue++;
			return;
		}
		
		f(row, col, size/2);
		f(row+size/2, col, size/2);
		f(row, col+size/2, size/2);
		f(row+size/2, col+size/2, size/2);
		return;
	}

}
