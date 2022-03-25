import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kyeee2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int N;
	static long [] D; // 15자리수
	
	// 참고 블로그 : https://m.blog.naver.com/occidere/220788046159
	// n = 5 인 경우
	// 10___ <- 기본적으로 앞에 두 자리는 저렇게 고정
	// 100000, 10001, 10010, 10100, 10101 이렇게 5가지가 가능한데
	// N = 4 -> 1(000), 1(001), 1(010)
	// N = 3 -> 100, 101
	// N = 5인 경우의 뒤의 3자리는 N = 4인 경우와 N = 3인 경우의 뒤에서 3자리의 경우와 동일하다
	// => D[i] = D[i - 1] + D[i - 2]
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		D = new long [N + 1];
		
		D[0] = 0;
		D[1] = 1;
		for(int i = 2; i <= N; i++) {
			D[i] = D[i - 1] + D[i - 2];
		}
		
		System.out.println(D[N]);
	}

}
