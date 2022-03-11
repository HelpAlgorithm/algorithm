import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Kyeee2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder outer = new StringBuilder();
	
	static int k;
	static int [] S;
	static int [] num = new int[6];

	public static void main(String[] args) throws IOException {
		while(true) {
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			
			k = Integer.parseInt(tokens.nextToken());
			if(k == 0) break;
			
			S = new int[k];
			for(int i = 0; i < k; i++) {
				S[i] = Integer.parseInt(tokens.nextToken());
			}
			
			combination(0, 0);
			outer.append('\n');
			
		}
		System.out.println(outer);
	}

	private static void combination(int cnt, int ind) {
		if(cnt == 6) {
			for(int i = 0; i < 6; i++) {
				if(i > 0) outer.append(" ");

				outer.append(num[i]);
			}
			outer.append('\n');
			
			return;
		}
		
		for(int i = ind; i < k; i++) {
			num[cnt] = S[i];
			combination(cnt + 1, i + 1);
		}
	}

}
