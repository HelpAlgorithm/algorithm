package boj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author chiyongs
 * @since 2022. 3. 2.
 * @see https://www.acmicpc.net/problem/2447
 * @performance 73592	332
 * @category #재귀
 * @note
 */

public class Chiyongs {
	
	static int N;
	static char[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		map = new char[N][N];
		calc(0,0,N);
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j] != '*') {
					sb.append(" ");
				} else sb.append("*");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	private static void print(int r,int c, int size) {
		for(int i=r;i<r+size;i++) {
			for(int j=c;j<c+size;j++) {
				if(i==r+1 && j==c+1) map[i][j] = ' ';
				else map[i][j] = '*';
			}
		}
	}
	
	private static void calc(int r,int c,int n) {
		if(n==3) {
			print(r,c,3);
			return;
		}
		
		int s = n/3;
		calc(r,c,s);
		calc(r,c+s,s);
		calc(r,c+2*s,s);
		calc(r+s,c,s);
		calc(r+s,c+2*s,s);
		calc(r+2*s,c,s);
		calc(r+2*s,c+s,s);
		calc(r+2*s,c+2*s,s);
	}
}
