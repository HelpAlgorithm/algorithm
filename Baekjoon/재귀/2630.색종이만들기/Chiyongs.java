package boj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * @author chiyongs
 * @since 2022. 3. 2.
 * @see https://www.acmicpc.net/problem/2630
 * @performance 13160	116
 * @category #재귀
 * @note
 */


public class Chiyongs {
	
	static int white,blue,arr[][],N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		for(int i=0;i<N;i++) {			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		calc(0,0,N);
		System.out.println(white);
		System.out.println(blue);
		

	}
	
	private static boolean isSame(int r,int c, int size) {
		int cur = arr[r][c];
		for(int i=r;i<size+r;i++) {
			for(int j=c;j<size+c;j++) {
				if(cur != arr[i][j]) return false;
			}
		}
		return true;
	}

	private static void calc(int r,int c,int size) {
		if(isSame(r,c,size)) {
			int cur = arr[r][c];
			if(cur == 0) {
				white++;
			} else {
				blue++;
			}
			return;
		}
		
		int half = size/2;
		calc(r,c,half);
		calc(r,c+half,half);
		calc(r+half,c,half);
		calc(r+half,c+half,half);		
		
	}
}
