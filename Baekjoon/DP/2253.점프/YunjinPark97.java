import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[] cantGo = new boolean[N+1];
		boolean[][] visited = new boolean[N+1][141];
		int[] dist = new int[N+1];
		Arrays.fill(dist, -1);
		for (int i = 0; i < M; i++) {
			cantGo[Integer.parseInt(br.readLine())] = true;
		}
		dist[1] = 0;
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {1, 0, 0});
		visited[1][0] = true;
		int cnt = 0;
		while (!queue.isEmpty()) {
			cnt++;
			int[] cur = queue.poll();
			int loc = cur[0], time = cur[1], x = cur[2];
			for (int i = -1; i <= 1; i++) {
				if (x+i < 1) continue;
				if (loc+x+i > N || cantGo[loc+x+i]) continue;
				if (visited[loc+x+i][x+i]) continue;
				if (dist[loc+x+i] < 0 || dist[loc+x+i] > time+1) {
					dist[loc+x+i] = time+1;
				}
				visited[loc+x+i][x+i] = true;
				queue.offer(new int[] {loc+x+i, time+1, x+i});
			}
		}
		System.out.println(dist[N]);
	}
}
