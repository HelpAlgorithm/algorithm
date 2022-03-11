package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_S2_6603_로또 {
	static int K;
	static int [] lotto ;
	static boolean[] isVisit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		while(true) {	// 0 입력시 종료
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			if(K == 0) {
				break;
			}
			
			lotto = new int[K];
			isVisit = new boolean[K];
			
			for(int i=0; i<K; i++) {
				lotto[i] = Integer.parseInt(st.nextToken());
			}
			comb(0,K,6);
			System.out.println();
		}
	}	
	public static void comb(int start, int end, int depth) {
	
		if(depth == 0) {
			for(int k=0; k<lotto.length; k++) {
				if(isVisit[k]) {
					System.out.print(lotto[k]+" ");
				}
			}
			System.out.println();
			return ;
		}
		for(int i=start; i<end; i++) {
			isVisit[i] = true;
			comb(i+1,end, depth-1);
			isVisit[i] = false;
		}
	}
	
}
