
import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
    	// 네트워크에 연결되어있지 않으면 bfs가 종료되게됨 -> 즉 컴퓨터의 개수만큼 0~N-1번까지 BFS를 돌릴때 BFS의 실행 횟수에 따라 네트워크 개수가 결정됨
    	// bfs가 끝날때마다 결과 값 +1 
        int[] network = new int[computers.length];
        int answer = 1;
        
        // BFS
        for(int i = 0; i < computers.length; i++){
            if(network[i] == 0){
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                network[i] = answer;
                
                while(!q.isEmpty()){
                    int cur = q.poll();
                    for(int next = 0; next < computers[cur].length; next++){
                        if(computers[cur][next] == 1 && network[next] == 0){
                            network[next] = 1;
                            q.add(next);
                        }
                    }
                }
                answer++;
            }
        }
        return answer - 1;  // 마지막에 어쩔수없이 한번 더 카운트가 되기 때문에 -1 해주기
    }
}