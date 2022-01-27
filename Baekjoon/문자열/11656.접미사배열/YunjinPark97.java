package stringManipulation;

/* 별로 효율적이진 않은듯?
 * 1) substring 연산 자체가 좀 많음
 * 2) 많은 println 출력
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Baekjoon11656_접미사배열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> list = new ArrayList<String>();
		String s = sc.next();
		
		for (int i = 0; i < s.length(); i++) {
			list.add(s.substring(i));
		}
		
		list.sort(Comparator.naturalOrder());
		for (String result: list) {
			System.out.println(result);
		}
	}

}
