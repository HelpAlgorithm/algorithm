import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		List<Integer> nums = new ArrayList<>();
		for (int i = 1; i <= K; i++) {
			nums.add(reverse(N*i));
		}
		Collections.sort(nums);
		System.out.println(nums.get(nums.size()-1));
	}

	static int reverse(int num) {
		int ret = 0;
		while (num > 0) {
			ret *= 10;
			ret += num % 10;
			num /= 10;
		}
		return ret;
	}
}
