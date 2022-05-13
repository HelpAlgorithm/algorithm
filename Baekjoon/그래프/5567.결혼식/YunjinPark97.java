import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Integer>());
		}
		boolean[] visited = new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			graph.get(v1).add(v2);
			graph.get(v2).add(v1);
		}
		
		int depth = 0;
		int ans = 0;
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.offer(1);
		visited[1] = true;
		while (depth < 2) {
			int size = queue.size();
			depth++;
			while (size-- > 0) {
				int from = queue.poll();
				for (int to: graph.get(from)) {
					if (visited[to]) continue;
					visited[to] = true;
					ans++;
					queue.offer(to);
				}
			}
		}
		
		System.out.println(ans);
	}

}
