class Solution {
    static int answer;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(0, 0, numbers.length, target, numbers);
        return answer;
    }
    
    static void dfs(int idx, int sum, int size, int target, int[] numbers){
        if (idx == size){
            if (sum == target) answer++;
            return;
        }
        
        dfs(idx+1, sum-numbers[idx], size, target, numbers);
        dfs(idx+1, sum+numbers[idx], size, target, numbers);
    }
}