
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon14891_톱니바퀴 {
	static String[] gears = new String[4];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 4; i++) {
			gears[i] = br.readLine();
		}
		int K = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] dirs = new int[4];
			int start = Integer.parseInt(st.nextToken()) -1;
			dirs[start] = Integer.parseInt(st.nextToken());
			
			int idx = 0;
			while (start+idx+1 < 4  || start-idx-1 >= 0) {
				if (start+idx+1 < 4 && gears[start+idx].charAt(2) != gears[start+idx+1].charAt(6)) {
					dirs[start+idx+1] = (-1) * dirs[start+idx];
				}
				if (start-idx-1 >= 0 && gears[start-idx].charAt(6) != gears[start-idx-1].charAt(2)) {
					dirs[start-idx-1] = (-1) * dirs[start-idx];
				}
				idx++;
			}
			
			for (int j = 0; j < 4; j++) {
				rotate(j, dirs[j]);
//				System.out.println(gears[j]);
			}
//			//System.out.println("________________");
		}

		int ans = 0;
		for (int i = 0; i < 4; i++) {
			ans += (1<<i) * (gears[i].charAt(0) - '0');
		}
		System.out.println(ans);
	}
	
	
	static void rotate(int gearIndex, int dir) {
		if (dir == 1) {
			gears[gearIndex] = gears[gearIndex].charAt(7) + gears[gearIndex].substring(0, 7);
		}
		else if (dir == -1){
			gears[gearIndex] = gears[gearIndex].substring(1, 8) + gears[gearIndex].charAt(0);
		}
	}

}
