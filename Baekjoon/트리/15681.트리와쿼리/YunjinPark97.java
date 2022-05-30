import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon15681_트리와쿼리개선 {
	
	static int[] dp, p;
	static List<List<Integer>> graph;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			graph.get(node1).add(node2);
			graph.get(node2).add(node1);
		}
		
		dp = new int[N+1];
		recur(R, 0);
		
		for (int i = 0; i < Q; i++) {
			sb.append(dp[Integer.parseInt(br.readLine())]+"\n");
		}
		System.out.println(sb.toString());
	}
	
	static int recur(int cur, int parent) {
		if (dp[cur] != 0) return dp[cur];
		int ret = 0;
		for (int nxt: graph.get(cur)) {
			if (nxt == parent) continue;
			ret += recur(nxt, cur);
		}
		return dp[cur] = ret + 1;
	}

}
