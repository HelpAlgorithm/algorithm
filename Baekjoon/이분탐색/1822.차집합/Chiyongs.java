package boj.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * @author chiyongs
 * @since 2022. 4. 14.
 * @see https://www.acmicpc.net/problem/1822
 * @performance 207940	1440
 * @category #TreeSet
 * @note
 */
public class BOJ_S4_1822_차집합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
				
		int cnt_a = Integer.parseInt(st.nextToken());
		int cnt_b = Integer.parseInt(st.nextToken());
		Set<Integer> a = new TreeSet<>();
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<cnt_a;i++) {
			a.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<cnt_b;i++) {
			int num = Integer.parseInt(st.nextToken());
			if(a.contains(num)) a.remove(num);			
		}
		
		sb.append(a.size()).append("\n");
		
		for(int x:a) {
			sb.append(x+" ");
		}
		
		System.out.println(sb.toString());
		

	}

}
