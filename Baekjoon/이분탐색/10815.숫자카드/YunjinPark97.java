package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// hashSet: 908ms, binary Search: 1300~1400ms, boolean array: 664ms

public class Baekjoon10815_숫자카드 {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		boolean[] cards = new boolean[20_000_001];
		for (int i = 0; i < N; i++) {
			cards[Integer.parseInt(st.nextToken()) + 10_000_000] = true;
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			sb.append(cards[Integer.parseInt(st.nextToken()) + 10_000_000]? 1+" ": 0+" ");
		}
		System.out.println(sb.toString());
	}

}
