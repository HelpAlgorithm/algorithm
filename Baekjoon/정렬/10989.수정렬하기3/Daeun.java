package algorithm_practice.Baekjoon.Sort;

import java.io.*;
import java.util.*;
 
public class Sort_2_10989 {
	// 카운팅 Sort : O(N) 사용해야함 -> N이 가장 큰 입력이라면 N+1의 카운팅 배열을 만들어서 저장 후 출력
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int n = Integer.parseInt(br.readLine());
		int[] input = new int[10001];
		
		for (int i = 0; i < n; i++) {
			input[Integer.parseInt(br.readLine())]++;
		}
		
		for (int i = 1; i < 10001; i++) {
			while (0 < input[i]--) {
				bw.write(Integer.toString(i) + "\n");
			}
		}
		br.close();
        bw.close();
	}

}

