import java.util.*;

class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);
        return answer;
    }

    public void dfs(int[] numbers, int depth, int target, int sum){
        if(depth == numbers.length){  // 종료 + 정답인지 확인
            if(target == sum){
              answer++;  
            } 
            return;
        }
        
        dfs(numbers, depth + 1, target, sum + numbers[depth]); // - 
        dfs(numbers, depth + 1, target, sum - numbers[depth]); // +
    }
}