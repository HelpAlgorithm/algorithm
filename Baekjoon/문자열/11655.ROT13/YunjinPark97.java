package stringManipulation;

import java.util.Scanner;

public class Baekjoon11655_ROT13 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String string = sc.nextLine();
	
		for (int i = 0; i < string.length(); i++) {
			char s = string.charAt(i);
			if (65 <= s && s < 91) {
				if (s < 78) {
					System.out.printf("%c", (s+13));
				}else {
					System.out.printf("%c", (s-13));
				}
			}else if (97 <= s && s < 123) {
				if (s < 110) {
					System.out.printf("%c", (s+13));
				}else {
					System.out.printf("%c", (s-13));
				}
			}else {
				System.out.printf("%c", s);
			}
		}		
		
	}

}
