package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 백준_G4_1759_암호만들기 {
	static int L, C;
	static String[] arr;
	static List<String> output = new ArrayList<>();
	static boolean[] isVisited;
	static int cnt = 0;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		arr = new String[C];
		isVisited = new boolean[C];
		
		for(int i=0; i<C; i++) {
			arr[i] = st.nextToken();
		}
		Arrays.sort(arr);
		/*	조건 : 최소 한개의 모음 (a, e, i, o, u) , 최소 두개의 자음 
		 *	무조건 오름차순
		 * */
		combination(arr, isVisited, 0, 0, L);
		System.out.println(sb.toString());
		
	}
	public static void combination(String[] arr, boolean[] isVisited, int start, int depth, int r) {
		String str = "";
		if (depth == r) {
			for (int i = 0; i < arr.length; i++) {
				if (isVisited[i])
					str += arr[i];
			}
			
			// 모음이 하나라도 있는지 체크하기
			if(str.contains("a") || str.contains("e") || str.contains("i") || str.contains("o") || str.contains("u")) {
				cnt = 0;
				for(int i=0; i<str.length(); i++) {
					char a = str.charAt(i);
					if(a != 'a' && a != 'e' &&  a != 'i' &&  a != 'o' &&  a != 'u') {
						cnt ++; // 자음 개수 cnt
					}
				}
				if(cnt >= 2) {
					sb.append(str+"\n");
					return;
				}
			}

		}
		for (int i = start; i < arr.length; i++) {
			if (!isVisited[i]) {
				isVisited[i] = true;
				combination(arr, isVisited, i + 1, depth + 1, r);
				isVisited[i] = false;
			}
		}
	}

}
