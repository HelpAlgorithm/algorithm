import java.util.Scanner;

public class Main {
	
	/**
	 * 배열을 -1로 초기화한 후
	 * 해당 알파벳 인덱스를 가진 곳에 등장 위치 기재
	 * 해당 위치가 -1이 아니라면 이미 등장한 적이 있는 알파벳이므로 패스
	 */

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
