import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int cnt = truck_weights.length, time = 0, sum = 0;
        Queue<Integer> trucks = new LinkedList<>();
        
        int i = 0; // 대기 트럭의 인덱스
        while(i < cnt) {
            time++;
            
            // 다리가 꽉 찼다면 빼주기
            if(trucks.size() == bridge_length) {
                sum -= trucks.poll();
            } 
            
            if(sum + truck_weights[i] <= weight) { // 트럭이 올라갈 수 있으면 트럭 올리고 
                trucks.offer(truck_weights[i]);
                sum += truck_weights[i];
                i++;
            } else { // 아니라면 더미 넣어주기
                trucks.offer(0);
            }
        }
        
        time += bridge_length; // 마지막 트럭이 빠져나오는데 걸리는 시간 더해주기
        
        return time;
    }
}