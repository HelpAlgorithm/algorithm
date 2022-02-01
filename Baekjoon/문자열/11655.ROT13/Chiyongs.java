import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		char[] ch = s.toCharArray();
		
		for(int i=0;i<s.length();i++) {
			if(Character.isAlphabetic(ch[i])) {
				if('a'<= ch[i] && ch[i]<='m') {
					ch[i] += 13;
				} else if('m'<=ch[i] && ch[i]<='z') {
					ch[i] -= 13;
				} else if('A'<= ch[i] && ch[i]<='M') {
					ch[i] += 13;
				} else if('M'<=ch[i] && ch[i]<='Z') {
					ch[i] -= 13;
				}
			}
		}
		System.out.println(String.valueOf(ch));
	}
}
