import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Kyeee2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N, M;
	static int [] nums;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		nums = new int [N];
		tokens = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(tokens.nextToken());
		}
		Arrays.sort(nums);
		
		M = Integer.parseInt(br.readLine());
		tokens = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			int findNum = Integer.parseInt(tokens.nextToken());
			
			boolean result = binarySearch(findNum);
			
			if(result) output.append("1 ");
			else	   output.append("0 ");
		}
		System.out.println(output);
	}

	private static boolean binarySearch(int num) {
		int start = 0, end = N - 1;
		
		while(start <= end) {
			int mid = (start + end) / 2;
			
			if(nums[mid] == num) return true;
			else if(nums[mid] < num) start = mid + 1;
			else	end = mid - 1;
		}
		
		return false;
	}

}
