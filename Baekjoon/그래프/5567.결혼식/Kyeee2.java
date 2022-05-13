import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Kyeee2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, M;
	static List<List<Integer>> graph = new ArrayList<>();
	
	static class Friend {
		int num, depth;
		
		public Friend(int n, int d) {
			this.num = n;
			this.depth = d;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		for(int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			tokens = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(tokens.nextToken());
			int n2 = Integer.parseInt(tokens.nextToken());
			
			graph.get(n1).add(n2);
			graph.get(n2).add(n1);
		}
		
		Queue<Friend> Q = new LinkedList<>();
		boolean [] visited = new boolean [N + 1];
		Q.offer(new Friend(1, 0)); // 상근이의 학번, 깊이
		visited[1] = true;
		
		int cnt = 0;
		while(!Q.isEmpty()) {
			Friend now = Q.poll();
			cnt++;
			
			if(now.depth == 2) continue;
			
			for(int i = 0; i < graph.get(now.num).size(); i++) {
				int n = graph.get(now.num).get(i);
				
				if(visited[n]) continue;
				
				Q.offer(new Friend(n, now.depth + 1));
				visited[n] = true;
			}
		}
		
		System.out.println(cnt - 1);
	}

}
