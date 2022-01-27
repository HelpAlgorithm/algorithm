package math;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon1929_소수구하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		boolean[] primeList = new boolean[n+1]; //각 idx에는 소수면 true, 아니면 false 값이 들어있음.
		Arrays.fill(primeList, true);
		primeList[0]= primeList[1] = false;
		
		for (int i = 0; i < n; i++) { // Math.power(n, 1/2)이 잘 안되서 바꿈: O(nloglogn) 동일하긴 해
			if (primeList[i]) {
				for (int j = 2*i; j < n+1; j += i) {
					primeList[j] = false;
				}
			}
		}
		
		for (int i = m; i <= n; i++) {
			if (primeList[i]) {
				System.out.println(i);
			}
		}
		
		sc.close();
	}

}
