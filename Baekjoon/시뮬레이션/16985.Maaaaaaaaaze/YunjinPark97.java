package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon16985_Maaaaaaaaaze {
	static int[][][][] maze = new int[4][5][5][5]; // 경우의 수 4가지 * 층수(위에서부터 0층) * row * col
	static List<int[]> perms = new ArrayList<int[]>();
	static boolean[] visited = new boolean[5];
	static int[] nums = {0, 1,2,3,4};
	static int[] input = new int[5];
			
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ans = 1000; // 적당히 큰 수
		int[] dr = {-1, 1, 0, 0, 0, 0};
		int[] dc = {0, 0, -1, 1, 0, 0};
		int[] dh = {0, 0, 0, 0, -1, 1};
		
		for (int k = 0; k < 5; k++) {
			for (int i = 0; i < 5; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()); 
				for (int j = 0; j < 5; j++) {
					maze[0][k][i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		for (int k = 0; k < 5; k++) {
			for (int n = 1; n < 4; n++) {
				rotate(k, n); // ok
			}
		}
		perm(0);
				
		for (int[] heightChoices: perms) {
			for (int i = 0; i < 1024; i++) {
				int temp = i;
				int[] rotationChoices = new int[5];
				int idx = 0;
				while (temp > 0) {
					rotationChoices[idx++] = (temp & 3);
					temp >>= 2;
				}
				
				int[][][] visited = new int[5][5][5];
				Queue<int[]> queue = new ArrayDeque<>();
				if (maze[rotationChoices[heightChoices[0]]][heightChoices[0]][0][0] == 0 || maze[rotationChoices[heightChoices[4]]][heightChoices[4]][4][4] == 0) continue;
				queue.offer(new int[] {heightChoices[0], 0, 0, 0});
				visited[heightChoices[0]][0][0] = 1;
				while (!queue.isEmpty()) {
					int[] elt = queue.poll();
					int r = elt[1];
					int c = elt[2];
					int h = elt[0];
					int hIdx = elt[3];
					for (int j = 0; j < 6; j++) {
						int nr = r + dr[j];
						int nc = c + dc[j];
						int nhIdx = hIdx + dh[j];
						if (nhIdx < 0 || nhIdx >= 5) continue;
						int nh = heightChoices[nhIdx];
						if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5) continue;
						if (maze[rotationChoices[nh]][nh][nr][nc] == 0 || visited[nh][nr][nc] > 0) continue;
						visited[nh][nr][nc] = visited[h][r][c] + 1;
						queue.offer(new int[] {nh, nr, nc, nhIdx});
					}
				}
				
				
				if (visited[heightChoices[4]][4][4] > 0) {
					ans = Math.min(ans, visited[heightChoices[4]][4][4]);
					//System.out.println(Arrays.toString(heightChoices) + " " + Arrays.toString(rotationChoices) + " " + ans);
				}
			}
		}
			
		
		if (ans == 1000) System.out.println(-1);
		else System.out.println(ans-1);
	}
	
	static void rotate(int k, int n) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				maze[n][k][i][j] = maze[n-1][k][4-j][i];
			}
		}
	}
	
	static void perm(int cnt) {
		if (cnt == 5) {
			int[] temp = new int[5];
			for (int i = 0; i < 5; i++) {
				temp[i] = input[i];
			}
			perms.add(temp);
			return;
		}
		
		for (int i = 0; i < 5; i++) {
			if (visited[i]) continue;
			input[cnt] = nums[i];
			visited[i] = true;
			perm(cnt+1);
			visited[i] = false;
		}
	}
}
























