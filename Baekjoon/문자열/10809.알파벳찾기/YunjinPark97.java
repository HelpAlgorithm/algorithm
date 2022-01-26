package stringManipulation;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon10809_알파벳찾기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[26];
		Arrays.fill(arr, -1);
		String s = sc.next();
		
		for (int i = 0; i<s.length(); i++) {
			if (arr[s.charAt(i) - 97] == -1) {
				arr[s.charAt(i) - 97] = i;
			}
		}
		for (int num: arr) {
			System.out.printf("%d ", num);
		}
	}

}
