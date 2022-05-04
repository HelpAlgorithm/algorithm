package boj.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Chiyongs {
	
	static int N,L, map[][], answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		calc();
		System.out.println(answer);
	}
	
	private static void calc() {
		for(int i=0;i<N;i++) {
			int[] temp = new int[N];
			System.arraycopy(map[i], 0, temp, 0, N);

			if(canGo(temp)) {
				answer++;
			}
			temp = new int[N];
			for(int j=0;j<N;j++) {
				temp[j] = map[j][i];
			}
			if(canGo(temp)) {
				answer++;
			}
		}
	}
	
	private static boolean canGo(int[] temp) {
		int prev = temp[0];
		int cnt = 1;
		boolean[] visited = new boolean[N];
		
		for(int i=1;i<N;i++) {
			int cur = temp[i];
			if(visited[i]) continue;
			if(prev == cur) {
				if(!visited[i-1]) cnt++;
			}
			else if(prev < cur) {
				// 오르막
				if(prev + 1 == cur && cnt >= L && !visited[i-1]) {
					// 오르막이면서 갈 수 있다.
					visited[i-1] = true;
					cnt = 1;
					prev = cur;
				} else {
					return false;
				}
			} else {
				// 내리막
				if(prev - 1 == cur) {
					int d = 0;
					for(int j=0;j<L && i+j < N;j++) {
						if(cur == temp[i+j]) {
							visited[i+j] = true;
							d++; 
						}
					}
					if(d >= L) {
						prev = cur;
						cnt = 1;
					} else {
						return false;
					}
				} else {
					return false;
				}
			}
		}
		return true;
	}
	

}
