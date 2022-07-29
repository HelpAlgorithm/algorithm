import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] nums = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		long ans = 1;
		for (int i = n-1; i >= 0; i--) {
			ans = (long) Math.ceil((double) ans / nums[i]) * nums[i];
		}
		System.out.println(ans);
	}

}
