package boj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author chiyongs
 * @since 2022. 3. 28.
 * @see https://www.acmicpc.net/problem/15988
 * @performance 19828	116
 * @category #DP
 * @note
 */
public class BOJ_S2_15988_123더하기3 {
	
	static final int DIV = 1000000009;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		long[] d = new long[1000001];
		d[1] = 1;
		d[2] = 2;
		d[3] = 4;
		
		for(int i=4;i<1000001;i++) {
			d[i] = (d[i-1]+d[i-2]+d[i-3]) % DIV;
		}
		
		System.out.println(Arrays.toString(d));
				
		for(int t=0;t<T;t++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(d[n]).append("\n");
		}
		
		System.out.println(sb.toString());

	}

}
