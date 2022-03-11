import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        // 그래프 생성
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // 그래프 그리기
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i != j && computers[i][j] == 1) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                    
                    computers[i][j] = 0;
                    computers[j][i] = 0;
                }
            }
        }
        
        int answer = 0; // 네트워크의 개수
        boolean [] visited = new boolean[n]; // 방문 여부
        for(int i = 0; i < n; i++) {
            if(visited[i]) continue;
            
            Queue<Integer> Q = new LinkedList<>();
            Q.offer(i);
            visited[i] = true;
            answer++; // 네트워크 찾음
            
            while(!Q.isEmpty()) {
                int vertex = Q.poll();
                
                for(int j = 0; j < graph.get(vertex).size(); j++) {
                    int v = graph.get(vertex).get(j); // vertex와 연결된 노드

                    if(visited[v]) continue;

                    Q.offer(v);
                    visited[v] = true;
                }
            }
        }
        return answer;
    }
}