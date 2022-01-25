package algorithm_me;

import java.util.Scanner;

public class Youngeun {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int n1 = scan.nextInt();
		int n2 = scan.nextInt();
		
		int g = gcd(n1, n2);
		int l = g * (n1 / g) * (n2 / g);
		
		System.out.println(g);
		System.out.println(l);
		
		scan.close();

	}

	private static int gcd(int n1, int n2) {
		if(n1 % n2 == 0) {
			return n2;
		} else {
			return gcd(n2, n1 % n2);
		}
	}

}
