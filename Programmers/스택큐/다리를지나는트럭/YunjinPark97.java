import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer= 0;
        Queue<Integer> bridges = new ArrayDeque<Integer>();
        int[] truckLocation = new int[truck_weights.length];
        int tempWeight = 0;
        int start = 0; //bridge에서 내리는 걸 확인하는 idx
        int end = 0; //bridge에 올릴 수 있는지 확인하는 idx
        while (start < truck_weights.length){
            // 1초동안 있는 차량 이동
            answer++;
            for (int i = start; i < end; i++){
                truckLocation[i] += 1;
            }
            // 내릴 차량 확인
            if (truckLocation[start] > bridge_length){
                tempWeight -= bridges.poll();
                start++; 
            }
            // 실을 수 있는 지 확인
            if (end < truck_weights.length && tempWeight + truck_weights[end] <= weight){
                bridges.offer(truck_weights[end]);
                tempWeight += truck_weights[end];
                truckLocation[end++] = 1;
            }
        }
        return answer;
    }
}