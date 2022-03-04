package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_S3_2630_색종이만들기 {
	static int N;
	static int white, blue;
	static int[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		white = 0; 
		blue = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		divide(0,0,N);
		sb.append(white+"\n"+blue);
		System.out.println(sb.toString());
	}
	
	public static void divide(int r, int c, int n){
		if(isSame(r,c,n)){	// 현재 n*n 사이즈의 공간이 전부 같은 색일떄 종료
			if(map[r][c] == 0){
				white += 1;
			}else if(map[r][c] == 1){
				blue += 1;
			}
			return;
		}
		
		// N * N 에서 N/2 * N/2로 분할
		divide(r, c, n/2);							// 좌 + 상
		divide(r, c + n/2, n/2);					// 좌 + 하
		divide(r + n/2, c, n/2);					// 우 + 상
		divide(r + n/2, c + n/2, n/2);				// 우 + 하
	
	}
	public static boolean isSame(int r, int c, int n){
		int cur = map[r][c];
		
		for(int i = r; i< r + n  ; i++){
			for(int j = c; j < c + n ; j++){
				if(map[i][j] != cur){ //첫 시작점과 다른 색이면 -> false 반환 
					return false;
				}
			}
		}
		return true;
	}
		

}
