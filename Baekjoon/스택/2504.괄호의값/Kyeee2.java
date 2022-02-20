import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_S2_2504_괄호의값 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {

		String str = br.readLine();
		Stack<Character> stack = new Stack<>();
		
		int mul = 1;
		int result = 0;
		boolean flag = true; // 95% 에서 계속 틀려서 추가해준 부분
		for(int i = 0; i < str.length(); i++) {
			switch(str.charAt(i)) {
			case '(':
				stack.push('(');
				mul *= 2;
				break;
				
			case '[':
				stack.push('[');
				mul *= 3;
				break;
				
			case ')':
				if(stack.isEmpty() || stack.peek() != '(') {
					flag = false; // 추가
					break;
				}
				
				if(str.charAt(i - 1) == '(') result += mul;
				stack.pop();
				mul /= 2;
				break;
				
			case ']':
				if(stack.isEmpty() || stack.peek() != '[') {
					flag = false; // 추가
					break;
				}
				
				if(str.charAt(i - 1) == '[') result += mul;
				stack.pop();
				mul /= 3;
				break;
			}
			
		}
		
		if(!flag || !stack.isEmpty()) { // 추가
			System.out.println(0);			
		} else {
			System.out.println(result);
		}
	}
	
}