package boj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 5. 11.
 * @see https://www.acmicpc.net/problem/2617
 * @performance 13584	124
 * @category #그래프
 * @note 인접리스트, 인바운드, 아웃바운드
 */
public class Chiyongs {
	
	static class Node {
		int vertex;
		Node link;
		
		public Node(int vertex, Node link) {
			this.vertex = vertex;
			this.link = link;
		}
	}

	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		Node[] in_nodes = new Node[n+1];
		Node[] out_nodes = new Node[n+1];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int big = Integer.parseInt(st.nextToken());
			int small = Integer.parseInt(st.nextToken());
			
			in_nodes[small] = new Node(big, in_nodes[small]);
			out_nodes[big] = new Node(small, out_nodes[big]);
		}
				
		
		int answer = 0;
		for(int i=1;i<=n;i++) {
			if(in_nodes[i] != null && !canMid(in_nodes,i)) answer++;
			if(out_nodes[i] != null && !canMid(out_nodes,i)) answer++;
		}
		
		
		System.out.println(answer);
		

	}
	
	private static boolean canMid(Node[] nodes, int start) {
		Queue<Node> Q = new LinkedList<>();
		Q.offer(nodes[start]);
		boolean[] visited = new boolean[n+1];
		visited[start]= true;
		
		while(!Q.isEmpty()) {
			Node cur = Q.poll();
			
			for(Node temp = cur;temp!=null;temp=temp.link) {
				if(!visited[temp.vertex]) {
					visited[temp.vertex] = true;
					Q.offer(nodes[temp.vertex]);
				}
			}
		}
		
		int cnt = 0;
		for(int i=1;i<=n;i++) {
			if(visited[i]) cnt++;
		}
		
		
		if(cnt > (n+1)/2) return false;
		else return true;
	}


}
