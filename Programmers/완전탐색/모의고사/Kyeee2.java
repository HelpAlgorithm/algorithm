import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int [][] persons = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        int [] cnts = new int[3];
        
        int max = -1;
        for(int p = 0; p < 3; p++) {
            int len = persons[p].length; // p+1 번째 사람의 정답 방식 개수
            int cnt = 0; // p+1 번째 사람의 정답 개수
            for(int i = 0; i < answers.length; i++) {
                if(answers[i] == persons[p][i % len]) {
                    cnt++;
                }
            }
            cnts[p] = cnt;
            if(cnt > max) {
                max = cnt;
            }
        }
        
        // 가장 많은 문제를 맞힌 사람을 임시로 List에 담기
        List<Integer> temp = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            if(max == cnts[i]) {
                temp.add(i+1);
            }
        }
        
        // 리스트를 배열로 옮기기
        int [] result = new int [temp.size()];
        for(int i = 0; i < temp.size(); i++) {
            result[i] = temp.get(i);
        }
        
        return result;
    }
}