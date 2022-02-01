package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class String_10809 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		int [] position = new int[26]; // 첫 등장 위치 저장
		int [] alpha = new int [26];
		
		for(int i=0; i<S.length(); i++){
			int index = S.charAt(i) - (int)'a';
			if(alpha[index] == 0) {	// 첫 등장
				position[index] = i;
			} 
			alpha[index] += 1;
		}
		
		for(int k=0; k<position.length; k++) {
			if(position[k] == 0 && alpha[k] == 0) {
				position[k] = -1;
			}
		}
		for(int c : position) {
			System.out.print(c + " ");
		}


	}

}
