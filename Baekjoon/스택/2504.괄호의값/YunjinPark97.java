package stack;

import java.util.Scanner;
import java.util.Stack;

public class Baekjoon2504_괄호의값 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		Stack<Character> stack = new Stack<Character>();
		int answer = 0;
		int temp = 1;
		boolean flag = true;
		outer: for (int i = 0; i < str.length(); i++) {
			switch (str.charAt(i)) {
			case '(':
				stack.push(str.charAt(i));
				temp *= 2;
				break;
			case '[':
				stack.push(str.charAt(i));
				temp *= 3;
				break;
			case ')':
				if (stack.isEmpty() || stack.peek() != '(') {
					flag = false;
					break outer;
				}
				if (str.charAt(i-1) == '(') {
					answer += temp;
				}
				stack.pop();
				temp /= 2;
				break;
			case ']':
				if (stack.isEmpty() || stack.peek() != '[') {
					flag = false;
					break outer;
				}
				if (str.charAt(i-1) == '[') {
					answer += temp;
				}
				stack.pop();
				temp /= 3;
				break;
			}
		}
		if (!stack.isEmpty()) flag = false;
		System.out.println((flag)? answer:0);
	}

}
