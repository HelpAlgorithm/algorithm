package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1439_뒤집기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int ans = 1;
		for (int i = 0; i < str.length()-1; i++) {
			if (str.charAt(i) != str.charAt(i+1)) ans++;
		}
		System.out.println(ans/2);
	}

}
