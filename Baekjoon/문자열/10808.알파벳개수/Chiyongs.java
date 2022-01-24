import java.util.Scanner;

public class Main {
	
	public int[] solution(String str) {
		char[] ch = str.toCharArray();
		int[] answer = new int[26];
		
		for(char c:ch) {
			answer[c-'a']++;
		}
		return answer;
	}

	public static void main(String[] args) {
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		for(int x: T.solution(str)) {
			System.out.print(x+" ");
		}
	}
	
}
