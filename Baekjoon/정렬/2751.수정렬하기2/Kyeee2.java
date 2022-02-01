package algorithm_me;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kyeee2 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		/*
		 * Arrays.sort 는 퀵정렬을 사용하는데,
		 * 퀵 정렬은 평균 O(NlogN)이지만 최악의 경우 O(N^2)을 사용한다!
		 * 
		 * 또한 System.out.println()으로만 출력하면 시간이 오래 걸린다
		 * */
		/*
		Integer [] nums = new Integer[N];
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(nums);
		
		for(Integer n: nums) {
			System.out.println(n);
		}
		*/
		
		/* Collection.sort를 사용하려면 리스트를 사용해야한다  */
		List<Integer> nums = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			nums.add(Integer.parseInt(br.readLine()));
		}
		
		/* Collections.sort() 사용하기 */
		Collections.sort(nums);
		
		/* 출력할 때 StringBuilder 사용하기 */
		StringBuilder sb = new StringBuilder();
		for(int num: nums) {
			sb.append(num).append('\n');
		}
		System.out.println(sb);
	}
	
}
