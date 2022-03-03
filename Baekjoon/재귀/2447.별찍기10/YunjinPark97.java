package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon15664_N과M10 {
	static int N, M;
	static int[] nums;
	static int[] input;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		nums = new int[M];
		input = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		combination(0, 0);
		System.out.println(sb);
	}

	public static void combination(int cnt, int start) {
		if (cnt == M) {
			for (int num: nums) {
				sb.append(num+" ");
			}
			sb.append("\n");
			return;
		}
		
		int prevNum = 0;
		for (int i = start; i < N; i++) {
			if (prevNum == input[i]) continue;
			prevNum = input[i];
			nums[cnt] = input[i];
			combination(cnt+1, i+1);
		}
	}
}
