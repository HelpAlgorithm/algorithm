import java.io.*;
import java.util.*;

public class Main {
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[] leafNum = new int[N+1];
		
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			leafNum[u]++;
			leafNum[v]++;
		}
		
		int cnt = 0;
		for (int i = 2; i <= N; i++) {
			if (leafNum[i] == 1) cnt++;
		}
		System.out.println((double) W / cnt);
	}

}
