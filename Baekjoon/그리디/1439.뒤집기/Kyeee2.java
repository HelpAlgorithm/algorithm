import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Kyeee2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int zeroCnt, oneCnt;
	static String S;

	public static void main(String[] args) throws IOException {
		S = br.readLine();
		
		tokens = new StringTokenizer(S, "0");
		zeroCnt = tokens.countTokens();
		
		tokens = new StringTokenizer(S, "1");
		oneCnt = tokens.countTokens();
		
		System.out.println(Math.min(zeroCnt, oneCnt));
	}

}
