package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Chiyongs {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String input = br.readLine();		
		
		int answer = 0;
		int dup = 0;
		for(int i=0;i<input.length();i++) {
			if(input.charAt(i) == '(') {
				dup++;
			} else if(input.charAt(i-1)== '(' && input.charAt(i) == ')') {
				dup--;
				answer += dup;				
			} else if(input.charAt(i-1) == ')' && input.charAt(i) == ')') {
				dup--;
				answer+=1;
			}
		}		
		System.out.println(answer);
	}

}
