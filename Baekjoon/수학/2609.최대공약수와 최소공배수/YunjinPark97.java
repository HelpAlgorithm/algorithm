package math;

import java.util.Scanner;

public class Baekjoon2609_최대공약수와최소공배수2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = Math.max(a, b);
		int d = Math.min(a, b);
		int r = c % d;
		while (r > 0) {
			c = d;
			d = r;
			r = c % d;
		}
		System.out.println(d);
		System.out.println(a*b/d);
		sc.close();
	}
}
	
