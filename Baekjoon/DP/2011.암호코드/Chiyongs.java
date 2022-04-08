package boj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author chiyongs
 * @since 2022. 4. 8.
 * @see https://www.acmicpc.net/problem/2011
 * @performance 11484	76
 * @category #DP
 * @note 엣지케이스가 너무 많고 복잡해서 하나하나 세심하게 따져보지 못해
 * 많이 틀렸다
 */
public class BOJ_G5_2011_암호코드 {

	static final int DIV = 1_000_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		int len = input.length;

		int[] d = new int[len];

		if (input[0] == '0') { // 처음이 0일때
			System.out.println(0);
			return;
		}
		if (len < 2) { // 처음이 0이 아닌데 한자리수 암호일때
			System.out.println(1);
			return;
		}
		d[0] = 1;
		d[1] = 1;
		int num = (input[0] - '0') * 10 + input[1] - '0';
		if (10 < num && num <= 26) { // 두 자리수인데 26보다 작을때
			d[1] = 2;
		}

		if (input[1] == '0') {
			if (input[0] < '1' || input[0] > '2') { // 암호가 아님 ex)30,50
				System.out.println(0);
				return;
			} else { // 하나로 취급 ex)10,20
				d[1] = 1;
			}
		}
		for (int i = 2; i < len; i++) {
			d[i] = d[i - 1] % DIV;
			if (input[i] == '0') {
				if (input[i - 1] < '1' || input[i - 1] > '2') { // xN0, N이 1이나 2가 아닐때 ex)1240, 2260
					System.out.println(0);
					return;
				} else { // x10,x20
					d[i] = d[i - 2] % DIV;
				}
			} else {
				num = (input[i - 1] - '0') * 10 + input[i] - '0';
				if (10 < num && num <= 26) { // xxx213처럼 xxx'21'3과 xxx2'13'으로 표현될 수 있는 것들
					d[i] = (d[i - 1] + d[i - 2]) % DIV;
				}
			}
		}

		System.out.println(d[len - 1] % DIV);

	}

}
