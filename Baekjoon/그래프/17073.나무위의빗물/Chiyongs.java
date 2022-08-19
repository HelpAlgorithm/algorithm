package boj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 7. 27.
 * @see https://www.acmicpc.net/problem/17073
 * @performance 167472	596
 * @category
 * @note 리프노드의 개수를 구하면 됨
 */
public class BOJ_G5_17073_나무위의빗물 {

    static class Node {
        int vertex;
        Node link;

        public Node(int vertex, Node link) {
            this.vertex = vertex;
            this.link = link;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        Node[] nodes = new Node[N+1];

        for(int i=0;i<N-1;i++) {
            st = new StringTokenizer(br.readLine()," ");

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            nodes[from] = new Node(to, nodes[from]);
            nodes[to] = new Node(from, nodes[to]);

        }

        Queue<Node> Q = new LinkedList<>();
        Q.offer(nodes[1]);
        boolean[] visited = new boolean[N+1];
        visited[1] = true;

        int leafCnt = 0;
        while(!Q.isEmpty()) {
            Node cur = Q.poll();
            boolean isLeaf = true;

            for(Node node = cur;node!=null;node=node.link) {
                if(visited[node.vertex]) continue;

                isLeaf = false;
                visited[node.vertex] = true;
                Q.offer(nodes[node.vertex]);
            }

            // 이 분기에 걸리면 리프노드, 왜냐? 더이상 인접한 노드가 없으므로
            if(isLeaf) {
                leafCnt++;
            }
        }

        System.out.printf("%.6f",(double) W / leafCnt);
    }
}
