import java.util.*;

class Solution {

    public int solution(int[] numbers, int target) {
        int answer = 0;

        Queue<Integer[]> Q = new LinkedList<>();
        Q.offer(new Integer[]{numbers[0],0});
        Q.offer(new Integer[]{-numbers[0],0});

        while(!Q.isEmpty()) {
            Integer[] cur = Q.poll();
            if(cur[0] == target && cur[1] == numbers.length-1) answer++;

            if(cur[1] == numbers.length-1) continue;
            int next = cur[1] + 1;
            int p = cur[0] + numbers[next];
            int m = cur[0] - numbers[next];

            Q.offer(new Integer[]{p,next});
            Q.offer(new Integer[]{m,next});
        }

        return answer;
    }
}