import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0, size=commands.length;i<size;i++) {
            int start = commands[i][0]-1;
            int end = commands[i][1];
            int k = commands[i][2]-1;
            
            int[] temp = Arrays.copyOfRange(array, start, end);
            Arrays.sort(temp);
            answer[i] = temp[k];            
        }
        return answer;
    }
}