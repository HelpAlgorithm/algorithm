import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Kyeee2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N;
	static int [] t, p, D;
	
	// 참고 블로그: https://hidelookit.tistory.com/118

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		t = new int [N]; // 상담을 완료하는데 걸리는 시간
		p = new int [N]; // 상담을 했을 때 받을 수 있는 금액
		D = new int [N + 1]; // 최대 수익

		for(int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			
			t[i] = Integer.parseInt(tokens.nextToken());
			p[i] = Integer.parseInt(tokens.nextToken());
		}
		
		for(int i = 0; i < N; i++) {
			if(i + t[i] <= N) {
				// 현재 i에서 상담일(t[i])를 더해 범위를 초과하지 않는 경우 dp 배열에 금액(p[i])를 더해준다.
				D[i + t[i]] = Math.max(D[i + t[i]], D[i] + p[i]);
			}
			// 중간에 비는 날이 없으므로 채워넣어주기
			D[i + 1] = Math.max(D[i], D[i + 1]);
		}
		
		System.out.println(D[N]);
	}

}
