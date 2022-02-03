package algorithm_me;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kyeee2 {

	/*
	 * Collections.sort 와 Arrays.sort 는 시간 초과가 뜸
	 * -> 카운팅 소트 기법 사용
	 * */
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int [] nums = new int[10001];
		int max = 0;
		
		/* Counting sort 기법 */
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			nums[num]++;
			if(max < num) {
				max = num;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= max; i++) {
			if(nums[i] > 0) {
				for(int j = 0; j < nums[i]; j++) {
					sb.append(i).append('\n');
				}
			}
		}
		System.out.println(sb);
	}
	
}