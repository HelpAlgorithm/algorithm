import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[] nums = new boolean[1001];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			nums[Integer.parseInt(st.nextToken())] = true;
		}
		
		int xyz = 51*51*51;
		for (int i = 1; i <= 51; i++) {
			if (nums[i]) continue;
			for (int j = 1; j <= 51; j++) {
				if (nums[j]) continue;
				for (int k = 1; k <= 1001; k++) {
					if (k < 1001 && nums[k]) continue;
					if (Math.abs(N-xyz) > Math.abs(N-i*j*k)) {
						xyz = i*j*k;
					}
				}
			}
		}
		System.out.println(Math.abs(N-xyz));
	}

}
