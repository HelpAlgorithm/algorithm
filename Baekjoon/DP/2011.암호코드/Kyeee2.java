import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kyeee2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int len, mod = 1_000_000;
	static int [] nums, D;

	public static void main(String[] args) throws IOException {
		String temp = br.readLine();
		len = temp.length();
		nums = new int [len + 1];
		for(int i = 1; i <= len; i++) {
			nums[i] = temp.charAt(i - 1) - '0';
		}
		
		D = new int [len + 1];
		
		// D[i]: i번째 수까지 읽을 수 있는 단어의 개수
		if(len == 1 && temp.charAt(0) == '0') {
			System.out.println(0);
			return;
		}
		
		// 초기값 설정
		D[0] = 1;
		
		for(int i = 1; i <= len; i++) {
			if(nums[i] != 0)  D[i] = (D[i] + D[i - 1]) % mod;
			
			if(i == 1) continue;
			
			int n = nums[i - 1] * 10 + nums[i];
			if(n >= 10 && n <= 26) D[i] = (D[i] + D[i - 2]) % mod;
		}
		
		System.out.println(D[len]);
	}

}
