package bj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Kyeee2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	
	static int T, N, max = -1;
	static long mod = 1000000009;
	static long [] D;
	static List<Integer> nums = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			nums.add(N);
			max = Math.max(max, N);
		}

		D = new long [max + 1];
		D[1] = 1;
		D[2] = 2;
		D[3] = 4;
		for(int i = 4; i <= max; i++) {
			D[i] = (D[i - 1] + D[i - 2] + D[i - 3]) % mod;
		}
		
		for(int t = 0; t < T; t++) {
			output.append(D[nums.get(t)] + "\n");
		}
		System.out.println(output);
	}

}
