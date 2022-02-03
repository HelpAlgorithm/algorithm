package algorithm_practice.Baekjoon.Sort;

import java.io.*;
import java.util.*;
 
public class Sort_2_11650 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		StringTokenizer st;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, (one, two) -> {	// Comparator 에 있는 compare 메서드를 구현하지 않고 람다로 사용
			if(one[0] == two[0]) {
				return one[1] - two[1];
			} else {
				return one[0] - two[0];
			}
		});
		
		StringBuilder sb = new StringBuilder();	
		for(int i = 0 ; i< N ; i++) {
			sb.append(arr[i][0] + " " + arr[i][1]).append('\n');
		}
		System.out.println(sb);
	}
 
 
}