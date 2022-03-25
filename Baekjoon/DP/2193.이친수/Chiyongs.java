package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Chiyongs {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		int n = Integer.parseInt(br.readLine());
		
		long[][] d = new long[91][2]; // 범위초과...
		d[1][0] = 0;
		d[1][1] = 1;
		d[2][0] = 1;
		d[2][1] = 0;
		
		
		for(int i=3;i<=n;i++) {
			d[i][0] = d[i-1][0] + d[i-1][1]; // i번째에 0이 들어가면 i-1번째에는 0과 1 둘다 가능
			d[i][1] = d[i-1][0]; // i번째에 1이 들어가면 i-1번째에는 0만 가능
		}
		
		System.out.println(d[n][0]+d[n][1]);

	}

}


