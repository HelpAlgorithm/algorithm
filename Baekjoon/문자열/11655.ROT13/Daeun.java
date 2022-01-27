package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class String_11655 {

	public static void main(String[] args) throws IOException {
		/* ROT13 : 알파벳을 13칸씩 밀어서 출력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char [] rStr = null;
		
		rStr = br.readLine().toCharArray();
		
		
		/* +13 이후에도 대문자, 소문자가 유지되어야 하므로 조건 추가 */
		 for (char ch : rStr) {
	            if (ch >= 'A' && ch <= 'Z') {
	                ch += 13;
	                if (ch > 'Z') {
	                    ch -= 26;
	                }
	            } else if (ch >= 'a' && ch <= 'z') {
	                ch += 13;
	                if (ch > 'z') {
	                    ch -= 26;
	                }
	            }
	            System.out.print(ch);
		 }


	}

}
