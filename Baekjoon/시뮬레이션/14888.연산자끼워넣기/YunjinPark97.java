package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon14888_연산자끼워넣기 {
	static int min, max, N;
	static int[] opers, nums;
	static int[] orders;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		nums = new int[N];
		orders = new int[N-1];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		opers = new int[4];
		for (int i = 0; i < 4; i++) {
			opers[i] = Integer.parseInt(st.nextToken());
		}
		
		min = 1_000_000_001;
		max = -1_000_000_001;
		
		perm(0);
		System.out.println(max);
		System.out.println(min);
	}
	
	static void perm(int cnt) {
		if (cnt == N-1) {
			int temp = nums[0];
			for (int i = 0; i < N-1; i++) {
				switch (orders[i]) {
				case 0:
					temp += nums[i+1];
					break;
				case 1:
					temp -= nums[i+1];
					break;
				case 2:
					temp *= nums[i+1];
					break;
				case 3:
					temp /= nums[i+1];
					break;
				}
			}
			if (temp > max) max = temp;
			if (temp < min) min = temp;
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if (opers[i] == 0) continue;
			orders[cnt] = i;
			opers[i]--;
			perm(cnt+1);
			opers[i]++;
		}
	}
}

























