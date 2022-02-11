import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Kyeee2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int total;
	static Stack<Character> stack = new Stack<>();
	
	public static void main(String[] args) throws IOException {
		String str = br.readLine();
		
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			
			if(ch == '(') {
				stack.push(ch);
			} else { // ch == ')'
				stack.pop();
				
				if(str.charAt(i - 1) == '(') {
					total += stack.size();
				} else {
					total++;
				}
			}
		}
		
		System.out.println(total);
	}
	
}