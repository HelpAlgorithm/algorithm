package algorithm;

import java.util.Scanner;

public class Youngeuns {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		char [] notation = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
							'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 
							'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
							'U', 'V', 'W', 'X', 'Y', 'Z'};
		
		int N = scan.nextInt();
		int B = scan.nextInt();
		
		String result = "";
		
		while(N > 0) {
			result += notation[N % B];
			N /= B;
		}
		
		for(int i = result.length() - 1; i >= 0; i--) {
			System.out.print(result.charAt(i));
		}
		
		scan.close();

	}

}
