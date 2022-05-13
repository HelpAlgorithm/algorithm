import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int ans, N, M, H;
	static int[][] ladders;
	
	public static void main(String[] args) throws IOException{
		ans = -1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		ladders = new int[H+1][N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			ladders[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
		}
		
		int num = 0;
		while (ans == -1 && num < 4) {
			comb(0, 0, num++);
		}
		
		System.out.println(ans);
	}
	
	
	static void comb(int cnt, int loc, int num) {
		if (cnt == num) {
			for (int j = 1; j <= N; j++) {
				if (!isValid(j)) return;
			}
			ans = num;
			return;
		}
		
		for (int i = loc; i < H*(N-1); i++) {
			int r = i/(N-1)+1, c= i%(N-1)+1;
			if (ladders[r][c]==1 || ladders[r][c-1] ==1) continue;
			ladders[r][c] = 1;
			comb(cnt+1, i+1, num);
			ladders[r][c] = 0;
		}
	}
	
	
	static boolean isValid(int j) {
		int idx = j;
		int i = 0;
		while (i <= H) {
			if (ladders[i][idx-1] == 1) idx--;
			else if (ladders[i][idx] == 1) idx++;
			i++;
		}
		return (idx == j);
	}

}
