import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Kyeee2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int L, C;
	static char [] alps;

	public static void main(String[] args) throws IOException {
		
		tokens = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		
		alps = new char[C];
		tokens = new StringTokenizer(br.readLine());
		for(int i = 0; i < C; i++) {
			alps[i] = tokens.nextToken().charAt(0);
		}
		
		Arrays.sort(alps);
		
		solution(0, 0, "");
		
		System.out.println(output);
	}

	private static void solution(int cnt, int start, String pw) { // cnt1: 모음의 개수
		if(pw.length() == L) {
			if(cnt >= 1 && pw.length() - cnt >= 2) { // 모음 1개 이상, 자음 2개 이상
				output.append(pw).append('\n');
			}
			
			return;
		}
		
		for(int i = start; i < C; i++) {
			if("aeiou".contains("" + alps[i])) {
				solution(cnt + 1, i + 1, pw + alps[i]);
			} else {
				solution(cnt, i + 1, pw + alps[i]);
			}
		}
	}

}
