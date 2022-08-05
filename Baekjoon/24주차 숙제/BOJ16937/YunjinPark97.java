import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		int[][] stickers = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			stickers[i][0] = Integer.parseInt(st.nextToken());
			stickers[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				int temp = stickers[i][0] * stickers[i][1];
				int r = H - stickers[i][0];
				int c = W - stickers[i][1];
				if (r < 0 || c < 0) continue;
				if ((Math.min(stickers[j][0], stickers[j][1]) <= Math.min(r, W) && Math.max(stickers[j][0], stickers[j][1]) <= Math.max(r, W))
					|| (Math.min(stickers[j][0], stickers[j][1]) <= Math.min(c, H) && Math.max(stickers[j][0], stickers[j][1]) <= Math.max(c, H))) {
					temp += stickers[j][0] * stickers[j][1];
					ans = Math.max(ans, temp);
				}
			}
			
			for (int j = i+1; j < N; j++) {
				int temp = stickers[i][0] * stickers[i][1];
				int r = H - stickers[i][1];
				int c = W - stickers[i][0];
				if (r < 0 || c < 0) continue;
				if ((Math.min(stickers[j][0], stickers[j][1]) <= Math.min(r, W) && Math.max(stickers[j][0], stickers[j][1]) <= Math.max(r, W))
					|| (Math.min(stickers[j][0], stickers[j][1]) <= Math.min(c, H) && Math.max(stickers[j][0], stickers[j][1]) <= Math.max(c, H))) {
					temp += stickers[j][0] * stickers[j][1];
					ans = Math.max(ans, temp);
				}
			}
		}
		System.out.println(ans);
	}

}
