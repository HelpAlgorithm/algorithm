package stringManipulation;

import java.util.Scanner;

public class Baekjoon10824_네수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		String c = sc.next();
		String d = sc.next();
		String abSum = a+b;
		String cdSum = c+d;
		System.out.println(Long.parseLong(abSum) + Long.parseLong(cdSum));
	}

}
