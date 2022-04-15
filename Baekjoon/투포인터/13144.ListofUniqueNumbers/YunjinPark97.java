package twoPointersAndSlidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon13144_ListofUniqueNumbers {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		long ans = 0;
		boolean[] res = new boolean[100001];
		int start = 0, end = 0;
		while (end < N) {
			if (!res[nums[end]]) {
				ans += (end - start + 1);
				res[nums[end++]] = true;
			} else {
				while (res[nums[end]]) {
					res[nums[start++]] = false;
				}
				ans += (end - start + 1);
				res[nums[end++]] = true;
			}
		}
		
		System.out.println(ans);
	}

}
