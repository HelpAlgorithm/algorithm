import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        List<Integer> list = new ArrayList<Integer>();
        Queue<Integer> queue = new ArrayDeque<Integer>();
        for (int priority: priorities){
            list.add(priority);
            queue.offer(priority);
        }
        Collections.sort(list);
        while (!queue.isEmpty()){
            if (queue.peek() == list.get(list.size()-1)){
                if (location == 0) {
                    answer++;
                    return answer;
                }
                answer++;
                queue.poll();
                list.remove(list.size()-1);
                location--;
            }
            else{
                if (location == 0){
                    queue.offer(queue.poll());
                    location = list.size()-1;
                }
                else{
                    queue.offer(queue.poll());
                    location--;
                }
            }
        }
        return answer;
    }
}