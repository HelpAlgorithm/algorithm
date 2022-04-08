import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num = br.readLine();
		int N = num.length();
		int[] dp = new int[N+1];
		dp[0] = 1; // 0자리수를 나타내는 방법은 1가지 (혹은 그냥 편의상)
		if (num.charAt(0) == '0') {
			System.out.println(0);
			return;
		}
		
		dp[1] = 1;
		for (int i = 2; i <= N; i++) {
			if (num.charAt(i-1) == '0') {
				if (num.charAt(i-2) > '2' || num.charAt(i-2) == '0') break;
				dp[i] = dp[i-2];
			}
			
			else {
				int temp = Integer.parseInt(num.substring(i-2, i));
				if (temp >= 10 && temp <= 26) dp[i] += dp[i-2];
				dp[i] += dp[i-1];
			}
			dp[i] %= 1_000_000;
		}
		System.out.println(dp[N]);
	}

}
