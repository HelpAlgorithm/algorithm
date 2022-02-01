package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s," ");
		String a = st.nextToken();
		String b = st.nextToken();
		String c = st.nextToken();
		String d = st.nextToken();
		
		String a_b = a+b;
		String c_d = c+d;
		
		System.out.println(Long.parseLong(a_b)+Long.parseLong(c_d));				
	}
}
