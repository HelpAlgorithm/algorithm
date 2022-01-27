package stringManipulation;


//출력 형식에 대한 질문: for문 안 쓰고 더 깔끔하게 할 수 있을까?
import java.util.Scanner;

public class Baekjoon10808_알파벳개수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String st = sc.next();
		int[] alphaNum = new int[26];
		
		for (int i = 0; i < st.length(); i++) {
			alphaNum[st.charAt(i) - 97] += 1;
		}
		for (int num: alphaNum) {
			System.out.printf("%d ", num);
		}
	}
}
