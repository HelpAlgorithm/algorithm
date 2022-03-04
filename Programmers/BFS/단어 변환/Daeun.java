import java.util.*;

class Solution {
    public static int answer;
    public static boolean[] visited;
    public static int min = Integer.MAX_VALUE;
    
    public int solution(String start, String target, String[] words) {
        answer = 0;
        visited = new boolean[words.length];        
        dfs(words, start, target, 0);
        
        return answer;
    }

    public static void dfs(String[] words, String start, String target, int depth){
        int sameCnt; 
        if(start.equals(target)){ // 현재 문자열이 target 과 동일한 경우
            min = Math.min(min, depth);
            if(min > words.length) min = 0;
            answer = min;
            return;
        }
        
      
        for(int i=0; i<words.length; i++){
            sameCnt = 0;
            if(visited[i])  continue; // 중복 방문 제거
            for(int j=0; j<words[i].length(); j++){ // 같은 글자 수 세기
                if(words[i].charAt(j) != start.charAt(j)) sameCnt++;
            }
            // 한글자만 다른 경우 -> 변경 가능 !
            if(sameCnt == 1){
                visited[i] = true;
                dfs(words, words[i], target, depth+1);
                visited[i] = false;
            }            
        }        
    }  
}