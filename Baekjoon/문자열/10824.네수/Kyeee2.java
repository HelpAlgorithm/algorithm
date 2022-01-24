package algorithm_me;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Kyeee2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		
		String n1 = tokens.nextToken() + tokens.nextToken();
		String n2 = tokens.nextToken() + tokens.nextToken();
		
		long sum = Long.parseLong(n1) + Long.parseLong(n2); // Long 타입으로 받는거 주의
		
		System.out.println(sum);
		
	}

}
