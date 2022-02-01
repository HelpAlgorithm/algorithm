package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class String_10824 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		String str = br.readLine();
		
		// int로 진행하게되면 AB or CD가 int의 범위를 넘어가서 틀렸다고 채점됨
		long AB;
		long CD;
		
		st = new StringTokenizer(str);

		AB = Long.valueOf(st.nextToken() + st.nextToken());
		CD = Long.valueOf(st.nextToken() + st.nextToken());
		
		System.out.println(AB+CD);
	}

}
