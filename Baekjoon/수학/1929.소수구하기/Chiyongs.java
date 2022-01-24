import java.util.ArrayList;
import java.util.Scanner;

/**
 * 에라토스테네스의 체
 * 임의의 자연수 n에 대해 그 이하의 소수를 찾는 가장 간단하고 빠른 방법
 * 1은 소수가 아니므로 2부터 반복문을 시작하여
 * 해당 i의 배수를 제거하고 주어진 m보다 큰 수들을
 * answer에 추가
 */

public class Main {
	
	public ArrayList<Integer> solution(int m, int n) {
		int[] nums = new int[n+1];
		ArrayList<Integer> answer = new ArrayList<>();
		
		for(int i=2;i<=n;i++) {
			if(nums[i] == 0) {
				if(i >=m)	answer.add(i);
				for(int j=i;j<=n;j=j+i) {
					nums[j] = 1;
				}
			}
		}
		
		return answer;
	}

	public static void main(String[] args) {
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		for(int x: T.solution(m, n)) {
			System.out.println(x);
		}
	}
	
}
