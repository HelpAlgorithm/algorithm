import java.util.Scanner;

public class Chiyongs {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();

		int max = 1;
		for (int i = 1; i <= (num1 > num2 ? num2 : num1); i++) {
			if (num1 % i == 0 && num2 % i == 0) {
				max = i;
			}
		}

		int min = max * (num1 / max) * (num2 / max);

		System.out.println(max);
		System.out.println(min);
	}

}
