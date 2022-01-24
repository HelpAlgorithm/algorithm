package algorithm_me;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Kyeee2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		int [] count = new int[26];
		Arrays.fill(count, -1); // -1로 다 채우기
		
		for(int ind = 0; ind < S.length(); ind++) {
			int alp = S.charAt(ind) - 'a';
			
			if(count[alp] == -1) {
				count[alp] = ind;
			}
		}
		
		for(int n: count) {
			System.out.print(n + " ");
		}
	}

}
