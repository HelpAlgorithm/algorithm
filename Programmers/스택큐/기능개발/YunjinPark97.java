import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> array = new ArrayList<Integer>();
        int idx = 0;
        int release = 0;
        while (idx < progresses.length){
            for (int i = idx; i < progresses.length; i++){
                progresses[i] += speeds[i];
            }
            if (progresses[idx] >= 100){
                while (idx < progresses.length && progresses[idx] >= 100){
                    release++;
                    idx++;
                }
                array.add(release);
                release = 0;
            }
        }
        int[] answer = new int[array.size()];
        for (int i = 0; i < array.size(); i++){
            answer[i] = array.get(i);
        }
        return answer;
    }
}