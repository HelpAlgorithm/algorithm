import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Kyeee2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N, M;
	static Map<String, String> sites = new HashMap<>();

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		for(int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			String site = tokens.nextToken();
			String pw = tokens.nextToken();
			
			sites.put(site, pw);
		}
		
		for(int i = 0; i < M; i++) {
			output.append(sites.get(br.readLine()) + "\n");
		}
		System.out.println(output);
	}

}
