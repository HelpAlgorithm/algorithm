package algorithm_me;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kyeee2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		String result = "";
		
		for(int i = 0; i < str.length(); i++) {
			char alp = str.charAt(i);
			
			if('a' <= alp && alp <= 'z') {
				int num = (alp - 'a' + 13) % 26;
				
				result += (char)(num + 'a');
			} else if('A' <= alp && alp <= 'Z') {
				int num = (alp - 'A' + 13) % 26;
				
				result += (char)(num + 'A');
			} else {
				result += alp;
			}
		}
		
		System.out.println(result);
		
	}

}
