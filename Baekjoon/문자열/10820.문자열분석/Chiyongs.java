import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public int[] solution(String str) {
		char[] ch = str.toCharArray();
		int[] answer = new int[4];
		
		for(char x:ch) {
			if(Character.isLowerCase(x)) {
				answer[0]++;
			} else if(Character.isUpperCase(x)) {
				answer[1]++;
			} else if(Character.isDigit(x)) {
				answer[2]++;
			} else if(Character.isSpaceChar(x)) {
				answer[3]++;
			}
		}
		
		return answer;
	}

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s ="";
		
		while((s = br.readLine()) != null) {
			for(int x: T.solution(s)) {
				System.out.print(x+" ");
			}
			System.out.println();
		}

	}
	
}
