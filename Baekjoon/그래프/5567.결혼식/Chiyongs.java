package boj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 5. 10.
 * @see https://www.acmicpc.net/problem/5567
 * @performance 14940	120
 * @category #그래프
 * @note
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

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		Node[] nodes = new Node[n+1];
		StringTokenizer st = new StringTokenizer("");
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			nodes[a] = new Node(b, nodes[a]);
			nodes[b] = new Node(a, nodes[b]);
		}
		
		boolean[] friend = new boolean[n+1];
		boolean[] invited = new boolean[n+1];
		friend[1] = true;
		invited[1] = true;
		
		for(int i=1;i<=n;i++) {
			for(Node temp = nodes[i];temp != null;temp = temp.link) {
				if(i == 1) {
					friend[temp.vertex] = true;
				} else {
					if(friend[i]) {
						invited[temp.vertex] = true;
					}
				}
			}
		}
		
		Set<Integer> set = new HashSet<>();
		for(int i=1;i<=n;i++) {
			if(friend[i] || invited[i]) set.add(i);
		}
		
		System.out.println(set.size()-1);
	}
}
