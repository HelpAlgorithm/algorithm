package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Chiyongs{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
				
		String[][] s = new String[n][2];
		
		for(int i=0;i<n;i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			s[i][0] = st.nextToken();
			s[i][1] = st.nextToken();
		}
		
		Arrays.sort(s, (o1, o2) -> {
			return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
		});
		
		for(String[] row:s) {
			System.out.println(row[0]+" "+row[1]);
		}
	}
}
