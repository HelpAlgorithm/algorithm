package math;
/*
 * 의의
 * 1) 아스키코드 값을 문자열로 바꾸기: Character.toString((char) i));
 * 2) 문자열 조작은 python마냥 편한 느낌이 있다.
 * 3) 출력 형식: list에 넣은 후 for문 sysout하는 풀이 있던데, 그게 더 느리지 않을까?
 */
import java.util.Scanner;

public class Baekjoon11005_진법변환2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int b = sc.nextInt();
		String answer = "";
		
		while (n > 0) {
			if (n % b < 10) {
				answer = String.valueOf(n % b) + answer;
			}else {
				answer = Character.toString((char) (n % b + 55)) + answer;
			}
			n /= b;
		}
		System.out.println(answer);
		sc.close();
	}

}
