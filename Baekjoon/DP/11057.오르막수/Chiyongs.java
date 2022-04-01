package boj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author chiyongs
 * @since 2022. 3. 28.
 * @see https://www.acmicpc.net/problem/11057
 * @performance 11840	80
 * @category #DP
 * @note
 */
public class BOJ_S1_11057_오르막수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		long[][] d = new long[1001][10];
		
		for(int i=0;i<10;i++) {
			d[1][i] = 1;
		}
		
		for(int i=2;i<1001;i++) {
			for(int j=0;j<10;j++) {
				long sum = 0;
				for(int k=j;k<10;k++) {
					sum += d[i-1][k];
				}
				d[i][j] = sum % 10007;
			}
		}
		
		long answer = 0;
		for(int i=0;i<10;i++) {
			answer += d[n][i];
			answer %= 10007;
		}
		
		System.out.println(answer);
		
	}

}
