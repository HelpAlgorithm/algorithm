import java.util.*;

class Solution {
	
	public int solution(int n, int[][] computers) {
        int answer = 0;

        // 방문 체크
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) { // 이전에 방문한 적이 없다면 == 네트워크에 연결되지 않았다면
                Queue<Integer> Q = new LinkedList<>();
                Q.offer(i);
                visited[i] = true;
                while (!Q.isEmpty()) {
                    int cur = Q.poll();

                    for (int j = 0; j < n; j++) {
                        if (visited[j])
                            continue;
                        if (computers[cur][j] == 1) {
                        	// 네트워크에 추가
                            visited[j] = true;
                            Q.offer(j);
                        }
                    }
                }
                // BFS를 돌며 i에서 갈 수 있는 정점들을 모두 방문했기 때문에 네트워크 갯수 증가
                answer++;
            }
        }

        return answer;
    }
}