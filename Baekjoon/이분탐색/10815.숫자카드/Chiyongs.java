package boj.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 4. 14.
 * @see https://www.acmicpc.net/problem/10815
 * @performance 166360	932	
 * @category #이분탐색
 * @note
 */
public class BOJ_S4_10815_숫자카드 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine()," ");
		int[] answer = new int[M];
		Arrays.sort(input);
		for(int i=0;i<M;i++) {
			int num = Integer.parseInt(st.nextToken());
			int result = Arrays.binarySearch(input, num);
			if(result >= 0) answer[i]++; 
		}
		
		for(int x:answer) {
			sb.append(x+" ");
		}
		
		System.out.println(sb.toString());
	}

}
