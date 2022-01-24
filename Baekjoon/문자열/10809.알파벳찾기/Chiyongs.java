import java.util.Scanner;

public class Main {

	public int[] solution(String str) {
		char[] ch = str.toCharArray();
		int[] answer = new int[26];
		for (int i = 0; i < 26; i++) {
			answer[i] = -1;
		}

		for (int i = 0; i < str.length(); i++) {
			if (answer[ch[i] - 97] == -1) {
				answer[ch[i] - 97] = i;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		for (int x : T.solution(str)) {
			System.out.print(x + " ");
		}
	}

}
