package boj.s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author chiyongs
 * @since 2022. 4. 8.
 * @see https://www.acmicpc.net/problem/1439
 * @performance 11484	80
 * @category #그리디
 * @note
 */

public class BOJ_S5_1439_뒤집기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		int zero = 0;
		int one = 0;
		
		// 처음 문자가 0이면 0의 갯수 증가, 1이면 1의 갯수 증가
		if(input[0] == '0') zero++;
		else one++;
		
		// 탐색하면서 cur과 다른 문자를 만나게 된다면 다음 문자에 따라서 갯수 증가
		for(int i=0;i<input.length-1;i++) {
			char cur = input[i];
			if(cur == input[i+1]) continue;
			else {
				if(cur == '0') one++;
				else zero++;
			}
		}

		System.out.println(Math.min(zero, one));
	}

}
