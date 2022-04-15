package twoPointersAndSlidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon2003_수들의합2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = 0;
		int start = 0, end = 1;
		int temp = nums[0];
		while (start < N) {
			if (temp < M) {
				if (end == N) break;
				temp += nums[end++];
			} else if (temp > M) {
				temp -= nums[start++];
			} else {
				ans++;
				temp -= nums[start++];
			}
		}
		
		System.out.println(ans);
	}

}
