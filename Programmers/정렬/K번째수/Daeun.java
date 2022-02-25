import java.util.*;

class Solution {
    static List<int[]> list = new ArrayList<int[]>();
    static int[] copy, cut;
    static int start, end, point;
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        copy = new int[3];

        // commands  -> copy에 옮겨서 start : i , end : j , point : k 로 저장 
//         for(int i=0; i<commands.length; i++){
//             copy = commands[i];
//             start = copy[0];
//             end = copy[1];
//             point = copy[2];

//             cut = new int[end-start+1];
//             cut = Arrays.copyOfRange(array, start-1, end);
//             Arrays.sort(cut);
//             answer[i]  = cut[copy[2]-1];
//         }

        // 풀이 2 -> 변수에 저장 따로 안하고 ,그냥 진짜 코드 몇줄로 끝내기 
        //          (솔직히 가독성이 너무 떨어져서 짜증나긴 함)
        for(int i=0; i<commands.length; i++){
            cut = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(cut);
            answer[i]  = cut[commands[i][2]-1];
        }

        return answer;
    }
}