import java.io.*;
import java.util.*;

public class Kyeee2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N;
	static long total;
	static Post [] nums;
	
	static class Post implements Comparable<Post> {
		int idx, n;
		
		public Post(int i, int n) {
			this.idx = i;
			this.n = n;
		}

		@Override
		public int compareTo(Post o) {
			if(this.idx == o.idx) {
				return Integer.compare(this.n, o.n);
			}
			return Integer.compare(this.idx, o.idx);
		}
	}
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		nums = new Post [N];
		for(int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(tokens.nextToken());
			int n = Integer.parseInt(tokens.nextToken());
			
			nums[i] = new Post(idx, n);
			total += n;
		}
		
		Arrays.sort(nums);
		
		long sum = 0;
		for(int i = 0; i < N; i++) {
			sum += nums[i].n;
			
			if(sum >= (total + 1) / 2) {
				System.out.println(nums[i].idx);
				break;
			}
		}
	}
}
