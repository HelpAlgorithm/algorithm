package algorithm_practice.Baekjoon.Sort;

import java.io.*;
import java.util.*;
 
public class Sort_2_11652 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] list = new long[N];	//	long으로 안하면 에러남.. 이 부분 몰라서 좀 헤맸음
		
		for(int i=0;i<N;i++) {
			list[i]=(Long.parseLong(br.readLine()));
		}	
		
		Arrays.sort(list);
		
		int cnt=1;
		int max=1;
		Long result = list[0];
		
		for(int i=1;i<N;i++) {
			if(list[i]==list[i-1])
				cnt += 1;
			else
				cnt=1;
			if(cnt>max) {
				max=cnt;
				result=list[i];
			}
		}
		
		System.out.println(result);
	}
}