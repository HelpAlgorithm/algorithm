package algorithm_practice.Baekjoon.Sort;

import java.io.*;
import java.util.*;
 
public class Sort_2_11651 {
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
		
		/* y 좌표(one[1], two[1]) 를 먼저 비교 후 -> x좌표 오름차순*/
		Arrays.sort(arr, (one, two) -> {
			if(one[1] == two[1]) {
				return one[0] - two[0];
			} else {
				return one[1] - two[1];
			}
		});
		
		StringBuilder sb = new StringBuilder();
		/* 출력은 x좌표 + y좌표 \n*/
		for(int i = 0 ; i< N ; i++) {
			sb.append(arr[i][0] + " " + arr[i][1]).append('\n');
		}
		System.out.println(sb);
	}
 
 
}