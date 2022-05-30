import java.io.*;
import java.util.*;

public class Kyeee2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	static int N, M, R;
	static int [] size; // 서브 트리의 정점 수
	static List<List<Integer>> graph = new ArrayList<>(); // 양방향 그래프
	static List<List<Integer>> tree = new ArrayList<>();  // 단방향 트리

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		R = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		for(int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
			tree.add(new ArrayList<>());
		}
		
		for(int i = 0; i < N - 1; i++) {
			tokens = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(tokens.nextToken());
			int v2 = Integer.parseInt(tokens.nextToken());
			
			// 우선 양방향으로 정해주기
			graph.get(v1).add(v2);
			graph.get(v2).add(v1);
		}
		
		makeTree();

		size = new int [N + 1];
		countSubTree(R);
		
		// 쿼리 실행
		for(int i = 0; i < M; i++) {
			int r = Integer.parseInt(br.readLine()); // 서브 트리의 루트
			
			output.append(size[r] + "\n");
		}
		System.out.println(output);
	}

	// 트리 만들어주기
	private static void makeTree() {
		Queue<Integer> Q = new LinkedList<>();
		boolean [] visited = new boolean [N + 1];
		
		// 루트 넣어주기
		Q.offer(R);
		visited[R] = true;
		
		while(!Q.isEmpty()) {
			int ver = Q.poll();
			
			for(int i = 0; i < graph.get(ver).size(); i++) {
				int v = graph.get(ver).get(i);
				
				if(visited[v]) continue;
				
				tree.get(ver).add(v);
				Q.offer(v);
				visited[v] = true;
			}
		}
	}

	// 서브 트리의 정점의 수
	private static void countSubTree(int root) {
		size[root] = 1;
		for(int ver: tree.get(root)) {
			countSubTree(ver);
			size[root] += size[ver];
		}
	}

}
