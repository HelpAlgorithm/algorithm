import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Kyeee2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int N;
	static int [] nums;
	static int [] operators; // 연산자 종류
	static boolean [] ch;
	static int [] op; // 실제 연산할 순서
	
	static int max = -100000001, min = 100000001;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		nums = new int [N];
		operators = new int [N - 1];
		ch = new boolean [N - 1];
		op = new int [N - 1];
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(tokens.nextToken());
		}
		
		tokens = new StringTokenizer(br.readLine());
		int ind = 0;
		for(int i = 0; i < 4; i++) {
			int n = Integer.parseInt(tokens.nextToken());
			for(int j = 0; j < n; j++) {
				operators[ind++] = i;
			}
		}
		
		calc(0);
		
		System.out.println(max);
		System.out.println(min);
	}

	private static void calc(int cnt) {
		if(cnt == N - 1) {
			int sum = nums[0];
			for(int i = 1; i < N; i++) {
				switch(op[i - 1]) {
				case 0: // +
					sum += nums[i];
					break;
				case 1: // -
					sum -= nums[i];
					break;
				case 2: // x
					sum *= nums[i];
					break;
				case 3: // /
					sum /= nums[i];
					break;
				}
			}
			
			if(sum > max) {
				max = sum;
			}
			if(sum < min) {
				min = sum;
			}
			
			return;
		}
		
		for(int i = 0; i < N - 1; i++) {
			if(!ch[i]) {
				ch[i] = true;
				op[cnt] = operators[i];
				calc(cnt + 1);
				ch[i] = false;
			}
		}
		
	}
	
}