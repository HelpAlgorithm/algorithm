import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kyeee2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int N, mod = 10007;
	static int [][] D;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		D = new int [N + 1][10];
		
		// 초기값 설정 (한 자리 수는 다 오르막 수)
		for(int i = 0; i < 10; i++) {
			D[1][i] = 1;
		}
		
		for(int i = 2; i <= N; i++) {
			for(int j = 0; j < 10; j++) {
				for(int k = 0; k <= j; k++) {
					D[i][j] = (D[i][j] + D[i - 1][k]) % mod;
				}
			}
		}
		
		int sum = 0;
		for(int i = 0; i < 10; i++) {
			sum = (sum + D[N][i]) % mod;
		}
		System.out.println(sum);
	}

}
