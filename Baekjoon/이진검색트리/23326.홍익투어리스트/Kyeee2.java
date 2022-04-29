import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Kyeee2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N, Q, now;
	static TreeSet<Integer> spots = new TreeSet<>();

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		Q = Integer.parseInt(tokens.nextToken());
		
		tokens = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			if(Integer.parseInt(tokens.nextToken()) == 1) spots.add(i);
		}
		
		now = 1;
		for(int t = 0; t < Q; t++) {
			tokens = new StringTokenizer(br.readLine());
			switch(tokens.nextToken()) {
			case "1":
				int n = Integer.parseInt(tokens.nextToken());
				if(spots.contains(n)) spots.remove(n);
				else		 		  spots.add(n);
				break;
			case "2":
				n = Integer.parseInt(tokens.nextToken());
				now = (now + n - 1) % N + 1;
				break;
			case "3":
				if(spots.isEmpty()) {
					output.append("-1\n");
				} else if(spots.contains(now)) {
					output.append("0\n");
				} else {
					Integer idx = spots.ceiling(now);
					if(idx != null) {
						output.append((idx - now) + "\n");
					} else {
						output.append((N - now + spots.first()) + "\n");
					}
				}
				break;
			}
		}
		System.out.println(output);
	}

}
