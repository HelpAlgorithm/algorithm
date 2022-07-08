import java.io.*;

public class Main {
	
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dfs(0, "");
	}

	static void dfs(int cnt, String str) {	
		for (int i = 1; i <= cnt/2; i++) {
			if (str.substring(str.length()-i, str.length()).equals(str.substring(str.length()-2*i, str.length()-i))) {
				return;
			}
		}
        
        if (cnt == N) {
			System.out.println(str);
			System.exit(0);
		}
		
		dfs(cnt+1, str+"1");
		dfs(cnt+1, str+"2");
		dfs(cnt+1, str+"3");
	}
}
