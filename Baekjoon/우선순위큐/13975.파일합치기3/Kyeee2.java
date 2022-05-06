import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Kyeee2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int T, N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			
			PriorityQueue<Long> pQ = new PriorityQueue<>();
			tokens = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				pQ.offer(Long.parseLong(tokens.nextToken()));
			}
			
			long total = pQ.poll() + pQ.poll();
			pQ.offer(total);
			
			while(pQ.size() > 1) {
				long sum = pQ.poll() + pQ.poll();
				total += sum;
				pQ.offer(sum);
			}
			
			output.append(total + "\n");
		}
		System.out.println(output);
	}

}
