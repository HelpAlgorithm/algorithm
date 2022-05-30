import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class YunjinPark97 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N, M;
		int[] p;
		int t = 1;
		List<List<Integer>> graph;
		StringBuilder sb = new StringBuilder();
		while ((N = Integer.parseInt(st.nextToken()))!= 0) {
			M = Integer.parseInt(st.nextToken());
			p = new int[N+1];
			graph = new ArrayList<>();
			for (int i = 0; i <= N; i++) {
				graph.add(new ArrayList<>());
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int node1 = Integer.parseInt(st.nextToken());
				int node2 = Integer.parseInt(st.nextToken());
				graph.get(node1).add(node2);
				graph.get(node2).add(node1);
			}
			
			// tree는 cycle이 없는 무방향 그래프: cycle을 발견하면 해당 연결구조는 tree가 아니다.
			int cnt = 0;
			
			p = new int[N+1];
			Arrays.fill(p, -1);
			for (int i = 1; i <= N; i++) {
				if (p[i] != -1) continue;
				p[i] = 0; // tree는 어느 점이든 root로 할 수 있다.
				Queue<Integer> q = new ArrayDeque<>();
				q.offer(i);
				boolean isTree = true;
				while (!q.isEmpty()) {
					int cur = q.poll();
					for (int nxt: graph.get(cur)) {
						if (p[cur] == nxt) continue;
						if (p[nxt] != -1) {
							isTree = false;
							continue;
						} 
						if (isTree) {
							p[nxt] = cur;
							q.offer(nxt);
						} else {
							p[nxt] = 0;
							q.offer(nxt);
						}
					}
				}
				if (isTree) cnt++;
			}
			if (cnt == 0) sb.append("Case "+t+": No trees.\n");
			else if (cnt == 1) sb.append("Case "+t+": There is one tree.\n");
			else sb.append("Case "+t+": A forest of "+cnt+" trees.\n");
			t++;
			st = new StringTokenizer(br.readLine());
		}
		System.out.println(sb.toString());
	}

}


































