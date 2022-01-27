package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String_10808 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		int [] cnt = new int[26];
		
		for(int i=0; i<S.length(); i++) {
			int index = S.charAt(i) - (int)'a';
			cnt[index] += 1;
		}
		
		for(int k=0; k<cnt.length; k++) {
			System.out.print(cnt[k]+" ");
		}
		
	
	}

}
