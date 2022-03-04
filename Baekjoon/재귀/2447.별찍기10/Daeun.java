package Baekjoon.Silver;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Daeun {
	static char map[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				star(i,j,N);
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());	
	}
	static void star(int i, int j, int N) {
		// 중간은 공백이고, 나머지 8칸은 *인 3X3 모양 반복
		if((i/N)%3 == 1 && (j/N)%3 == 1 ) {	// 정 중앙인 경우 
			map[i][j]=' ';
		}
		else {
			if(N/3 == 0) {
				map[i][j]='*';
			} 
			
			else {
				star(i,j,N/3);
			}
		}
	}
    
}