package algorithm_practice.Baekjoon.Sort;

import java.io.*;
import java.util.*;
 
public class Sort_2_10814 {

	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   	int N = Integer.parseInt(br.readLine());
	   	String[][] arr = new String[N][2];
	   	
	   	for(int i =  0 ; i < N ; i++) {
   	 		String[] st = br.readLine().split(" ");
   	 		arr[i][0] = st[0];
   	 		arr[i][1] = st[1];
   	 	}
	   	 
//	   	나이가 증가하는 순으로, 나이가 같으면 먼저 가입한 사람이 앞에 오는 순서로 정렬
   	 	Arrays.sort(arr, new Comparator<String[]>() {
   	 		@Override
   	 		public int compare(String[] s1, String[] s2) {
	   	 		if(s1[0] == s2[0]) {
	   	 			return 1;
	   	 		}else {
	   	 			return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
	   	 		}
   	 		}
   	 	});
   
   	 	
   	 	for(int i = 0; i < N; i++) {
			System.out.println(arr[i][0] +" "+ arr[i][1]);
 		}
	}
}

