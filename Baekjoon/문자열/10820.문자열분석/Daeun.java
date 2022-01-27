package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String_10820 {
//	문제
//	문자열 N개가 주어진다. 이때, 문자열에 포함되어 있는 소문자, 대문자, 숫자, 공백의 개수를 구하는 프로그램을 작성하시오.
//
//	각 문자열은 알파벳 소문자, 대문자, 숫자, 공백으로만 이루어져 있다.
//
//	입력
//	첫째 줄부터 N번째 줄까지 문자열이 주어진다. (1 ≤ N ≤ 100) 문자열의 길이는 100을 넘지 않는다.
//
//	출력
//	첫째 줄부터 N번째 줄까지 각각의 문자열에 대해서 소문자, 대문자, 숫자, 공백의 개수를 공백으로 구분해 출력한다.
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = "";
		while((S = br.readLine()) != null ) {
			int small = 0;
			int big = 0;
			int num = 0;
			int space = 0;
			
			// 공백 ASCII : 32,  소문자 : 97~122  대문자:65~90  숫자 : 0 ~ 9
			for(int i = 0; i<S.length(); i++) {
				int index = S.charAt(i);
				if(index >= 97 && index <= 122) {
					// 소문자
					small++;
				}else if(index >= 65 && index <= 90) {
					// 대문자
					big++;
				}else if(index >= 48 && index <= 57) {	// 숫자인 경우
					num++;
				}else if(index == 32) {	// 공백
					space++;
				}					
			}
			System.out.println(small + " " + big + " " + num+ " " +space);

		}
			
		
	}


}
