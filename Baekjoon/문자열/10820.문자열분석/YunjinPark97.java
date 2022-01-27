package stringManipulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon10820_문자열분석 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st;
		while ((st = br.readLine()) != null){
			int[] answer = new int[4];
			for (int i = 0; i < st.length(); i++) {
				char letter = st.charAt(i);
				if (letter >= 97 && letter < 123) {
					answer[0] += 1;
				}else if (letter >= 65 && letter < 91) {
					answer[1] += 1;
				}else if (letter >= 48 && letter < 58) {
					answer[2] += 1;
				}else {
					answer[3] += 1;
				}
			}
			for (int ans: answer) {
				System.out.printf("%d ", ans);
			}
			System.out.println();
		}
	}

}
