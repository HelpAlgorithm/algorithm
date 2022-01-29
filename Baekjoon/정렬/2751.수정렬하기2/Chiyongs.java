package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Chiyongs {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		
		// sysout하니깐 시간초과나서 StringBuilder로 했더니 성공!

		for (int x : arr) {
			sb.append(x);
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
