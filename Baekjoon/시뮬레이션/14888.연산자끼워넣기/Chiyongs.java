package boj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 4. 11.
 * @see https://www.acmicpc.net/problem/14888
 * @performance 14624	96
 * @category #완전탐색
 * @note
 */
public class BOJ_S1_14888_연산자끼워넣기 {

	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int[] arr,operators;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		operators = new int[4];

		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0;i<4;i++) {
			operators[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(1,arr[0]);
		
		System.out.println(max);
		System.out.println(min);

	}

	private static void dfs(int cnt, int result) {
		if(cnt == N) {
			// 최댓값, 최솟값 판별
			if(result > max) max = result;
			if(result < min) min = result;
			return;
		}
		
		for(int i=0;i<4;i++) {
			// 연산자 별로 재귀들어가봄
			// 하나의 cnt에서 결국 모든 연산자를 다 가봄
			// 완탐
			if(operators[i]>0) {
				operators[i]--;
				if(i==0) dfs(cnt+1, result+arr[cnt]);
				else if(i==1) dfs(cnt+1, result-arr[cnt]);
				else if(i==2) dfs(cnt+1, result*arr[cnt]);
				else {
					if(result < 0) dfs(cnt+1,((result * -1) / arr[cnt])*-1);
					else dfs(cnt+1, result/arr[cnt]);
				}
				operators[i]++;
			}
		}
	}
	

}
