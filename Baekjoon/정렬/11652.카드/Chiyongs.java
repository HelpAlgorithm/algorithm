package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		long[] nums = new long[n];
				
		for(int i=0;i<n;i++) {
			nums[i] = Long.parseLong(br.readLine());
		}
		
		// n의 크기가 10만이므로 O(n^2)는 시간 초과남
		Arrays.sort(nums);
		
		
		long answer = nums[0];
		int count = 1;
		int max = 1;
		for(int i=0;i<n-1;i++) {
			if(nums[i] == nums[i+1]) {
				count ++;
			} else {
				count = 1;
			}
			if(count> max) {
				max = count;
				answer = nums[i];
			}
		}
		
		System.out.println(answer);
		
	}
}
