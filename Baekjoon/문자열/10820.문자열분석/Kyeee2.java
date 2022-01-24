package algorithm_me;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kyeee2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = "";
		while((str = br.readLine()) != null) {
			int [] result = new int[4]; // 소문자, 대문자, 숫자, 공백 순서
			
			for(int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				
				if('a' <= ch && ch <= 'z') {
					result[0]++;
				} else if('A' <= ch && ch <= 'Z') {
					result[1]++;
				} else if('0' <= ch && ch <= '9') {
					result[2]++;
				} else {
					result[3]++;
				}
			}
			
			for(int n: result) {
				System.out.print(n + " ");
			}
			System.out.println();
		}
	}

}
