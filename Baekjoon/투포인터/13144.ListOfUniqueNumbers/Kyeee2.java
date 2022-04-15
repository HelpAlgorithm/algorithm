import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Kyeee2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N;
	static long cnt;
	static int [] nums;
	static boolean [] selected;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		nums = new int [N];
		tokens = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(tokens.nextToken());
		}

		selected = new boolean [100001];
		int end = 0;
		for(int start = 0; start < N; start++) {
			while(end < N) {
				if(selected[nums[end]]) break;
				selected[nums[end]] = true;
				end++;
			}
			cnt += (end - start);
			selected[nums[start]] = false;
		}
		
		System.out.println(cnt);
	}

}
