package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon6603_로또2 {
	static StringBuilder sb;
	static int N;
	static int[] input;
	static int[] result = new int[6];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			if (N == 0) break;
			
			input = new int[N];
			for (int i = 0; i < N; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			comb(0, 0);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void comb(int cnt, int idx) {
		if (cnt == 6) {
			for (int i = 0; i < 6; i++) {
				sb.append(result[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = idx; i < N; i++) {
			result[cnt] = input[i];
			comb(cnt+1, i+1);
		}
	}

}










