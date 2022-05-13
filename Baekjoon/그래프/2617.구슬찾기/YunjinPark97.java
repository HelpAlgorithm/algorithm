import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<List<Integer>> heavier = new ArrayList<>();
		List<List<Integer>> lighter = new ArrayList<>();
		int[] heavierNum = new int[N+1];
		int[] lighterNum = new int[N+1];
		
		for (int i = 0; i <= N; i++) {
			heavier.add(new ArrayList<>());
			lighter.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int pebble1 = Integer.parseInt(st.nextToken());
			int pebble2 = Integer.parseInt(st.nextToken());
			heavier.get(pebble1).add(pebble2);
			lighter.get(pebble2).add(pebble1);
		}
		
		
		for (int i = 1; i <= N; i++) {
			Queue<Integer> queue = new ArrayDeque<>();
			boolean[] visited = new boolean[N+1];
			int ans = 0;
			visited[i] = true;
			queue.offer(i);
			while (!queue.isEmpty()) {
				int from = queue.poll();
				for (int to: lighter.get(from)) {
					if (visited[to]) continue;
					ans++;
					visited[to] = true;
					queue.offer(to);
				}
			}
			lighterNum[i] = ans;
		}
		
		
		for (int i = 1; i <= N; i++) {
			Queue<Integer> queue = new ArrayDeque<>();
			boolean[] visited = new boolean[N+1];
			int ans = 0;
			visited[i] = true;
			queue.offer(i);
			while (!queue.isEmpty()) {
				int from = queue.poll();
				for (int to: heavier.get(from)) {
					if (visited[to]) continue;
					ans++;
					visited[to] = true;
					queue.offer(to);
				}
			}
			heavierNum[i] = ans;
		}
		
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			if (lighterNum[i] >= (N+1)/2 || heavierNum[i] >= (N+1)/2) {
				ans++;
			}
		}
		
		System.out.println(ans);
	}

}
