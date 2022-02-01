package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String[] arr = new String[s.length()];
		for(int i=0;i<s.length();i++) {
			String temp = "";
			for(int j=i;j<s.length();j++) {
				temp += s.charAt(j);
			}
			arr[i] = temp;
		}
		Arrays.sort(arr);
		
		for(String x:arr) {
			System.out.println(x);
		}		
	}
}
