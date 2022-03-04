package bj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kyeee2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				draw(r, c, N);
			}
			output.append('\n');
		}
		
		System.out.println(output);
	}

	private static void draw(int r, int c, int size) {
		if((r / size) % 3 == 1 && (c / size) % 3 == 1) {
			output.append(' ');
		} else {
			if(size/ 3 == 0) {
				output.append('*');
			} else {
				draw(r, c, size / 3);
			}
		}
	}

}
