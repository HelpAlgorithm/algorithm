package algorithm_practice;

import java.util.Scanner;

public class DaeunKim {

	public static void main(String[] args) {
		int N ,B;
		String result ="";
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		B = sc.nextInt();
		
		result = changeNotation(N, B);
		System.out.print(result);
		
	}
   
	public static String changeNotation(int N, int B) {
		int temp = 0;
		String result = "";
		
		while(N != 0) {
			temp = N / B;	
			
			if(N % B <10) { // 0~9까지만 숫자로 표현 가능 , 10 부터는 영어로 표기해야함 
				result = N % B + result;
			}else {	// A : 65, B : 66 ~ Z : 91  --> 10을 A로 넣으려면  + 55 필요
				result = (char)(N % B + 55) + result;
			}
			N = N / B;
		}
		return result;
	}

}