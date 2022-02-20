import java.util.*;
import java.io.*;

class Solution {
    static Queue<Integer> bQueue = new LinkedList<Integer>();	// 다리의 상태를 저장할 큐
    static int answer = 0;
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int sum = 0;
        
        for(int i=0; i<truck_weights.length; i++) {
			while(true) { // 다리가 비어있다면 다음 트럭(=무게)를 큐에 입력 후, for문 진행
				if(bQueue.isEmpty()) {
					bQueue.offer(truck_weights[i]);
					sum += truck_weights[i];
					answer++;
					break;
				}
				//큐의 사이즈 == 다리의 길이 -> 다리가 꽉찼으며, 이제 맨 앞 차가 나갈 차례 
				else if(bQueue.size() == bridge_length) {	// 다리의 맨 앞차 out + 무게도 빼야함
					sum -= bQueue.poll(); 
				}
				//다리가 비어있지 않는 경우 (다리에 차가 남아있음)
				else {
					//들어오지 못하는 경우 (무게 초과)
					if(sum + truck_weights[i] > weight) {
						bQueue.offer(0);
						answer++;
					}
					// 들어올 수 있는 경우 -> 다리큐에 트럭 입력 + 무게 합산 + 1초 추가후 for문 재 진행
					else {
						bQueue.offer(truck_weights[i]);
						sum += truck_weights[i];
						answer++;
						break;
					}
				}
			}
        }
      
		//총 걸린시간 : 위의 answer 결과 + 마지막 트럭의 통과시간 (= 다리의 길이)
		return answer + bridge_length;
	}

}