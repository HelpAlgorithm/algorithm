package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Baekjoon1822_차집합2 {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		List<Integer> listA = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < A; i++) {
			listA.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		Set<Integer> setB = new HashSet<>();
		for (int i = 0; i < B; i++) {
			setB.add(Integer.parseInt(st.nextToken()));
		}
		int ans = 0;
		
		Collections.sort(listA);
		
		for (int i = 0; i < A; i++) {
			if (!setB.contains(listA.get(i))) {
				ans++;
				sb.append(listA.get(i)+" ");
			}
		}
			
		
		System.out.println(ans);
		if (ans > 0) System.out.println(sb.toString());		
	}

}





































