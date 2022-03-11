import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++){
            if (!visited[i]){
                queue.offer(i);
                visited[i] = true;
                answer++;
                while(!queue.isEmpty()){
                    int cur = queue.poll();
                    for (int nxt = 0; nxt < n; nxt++){
                        if ((cur == nxt) || visited[nxt] || computers[cur][nxt] == 0) continue;
                        visited[nxt] = true;
                        queue.offer(nxt);
                    }
                }
            }
        }
        
        return answer;
    }
}