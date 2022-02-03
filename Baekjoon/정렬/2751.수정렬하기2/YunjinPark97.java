package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baekjoon2751_수정렬하기2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		List<Integer> intList = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			 intList.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(intList);;
		for (int num: intList) {
			sb.append(num+"\n");
		}
		System.out.println(sb);
	}

}
