import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++){
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < commands[i][1] - commands[i][0] + 1; j++){
                list.add(array[commands[i][0] - 1 + j]);
            }
            Collections.sort(list);
            answer[i] = list.get(commands[i][2]-1);
        }
        return answer;
    }
}