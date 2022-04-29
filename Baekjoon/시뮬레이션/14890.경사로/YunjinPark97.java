import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, L;
	static int[][] map;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = 0;
		for (int i = 0; i < N; i++) {
			ans += check(true, i);
			ans += check(false, i);
		}
		System.out.println(ans);
	}
	
	
	static int check(boolean isRow, int idx) {
		if (isRow) {
			boolean[] visited = new boolean[N];
			for (int j = 0; j < N-1; j++) {
				if (Math.abs(map[idx][j] - map[idx][j+1]) > 1) return 0; 
				else if (map[idx][j] - map[idx][j+1] == -1) {
					Queue<Integer> queue = new ArrayDeque<>();
					int x = 0;
					while (queue.size() < L && j-x >= 0 && !visited[j-x] && map[idx][j] == map[idx][j-x]) {
						queue.offer(j-x);
						x++;
					}
					if (queue.size() == L) {
						while (!queue.isEmpty()) {
							visited[queue.poll()] = true;
						}
					} else {
						return 0;
					}
					
				} else if (map[idx][j] - map[idx][j+1] == 1) {
					Queue<Integer> queue = new ArrayDeque<>();
					int x = 0;
					while (queue.size() < L && j+1+x < N && !visited[j+1+x] && map[idx][j+1] == map[idx][j+1+x]) {
						queue.offer(j+1+x);
						x++;
					}
					if (queue.size() == L) {
						while (!queue.isEmpty()) {
							visited[queue.poll()] = true;
						}
					} else {
						return 0;
					}
				}
			}
		}
		else {
			boolean[] visited = new boolean[N];
			for (int i = 0; i < N-1; i++) {
				if (Math.abs(map[i][idx] - map[i+1][idx]) > 1) return 0; 
				else if (map[i][idx] - map[i+1][idx] == -1) {
					Queue<Integer> queue = new ArrayDeque<>();
					int x = 0;
					while (queue.size() < L && i-x >= 0 && !visited[i-x] && map[i-x][idx] == map[i][idx]) {
						queue.offer(i-x);
						x++;
					}
					if (queue.size() == L) {
						while (!queue.isEmpty()) {
							visited[queue.poll()] = true;
						}
					} else {
						return 0;
					}
					
				} else if (map[i][idx] - map[i+1][idx] == 1) {
					Queue<Integer> queue = new ArrayDeque<>();
					int x = 0;
					while (queue.size() < L && i+1+x < N && !visited[i+1+x] && map[i+1+x][idx] == map[i+1][idx]) {
						queue.offer(i+1+x);
						x++;
					}
					if (queue.size() == L) {
						while (!queue.isEmpty()) {
							visited[queue.poll()] = true;
						}
					} else {
						return 0;
					}
				}
			}
		}
		
		return 1;
	}

}
