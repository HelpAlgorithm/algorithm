import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Kyeee2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, cnt;
	static long M;
	static int [] A;
	static long [] D;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Long.parseLong(tokens.nextToken());
		
		A = new int [N + 1];
		tokens = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(tokens.nextToken());
		}
		
		// 누적합 구하기
		D = new long [N + 1];
		for(int i = 1; i <= N; i++) {
			D[i] = D[i - 1] + A[i];
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = i; j <= N; j++) {
				long sum = D[j] - D[i - 1];
				
				if(sum == M) cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}
