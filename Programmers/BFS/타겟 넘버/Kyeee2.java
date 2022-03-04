class Solution {
    int answer;
    public int solution(int[] numbers, int target) {
        
        dfs(0, 0, numbers, target);
        
        return answer;
    }
    
    private void dfs(int ind, int sum, int[] numbers, int target) {
        if(ind == numbers.length) {
            if(sum == target) answer++;
            return;
        }
        
        // 현재 인덱스에 위치한 숫자를 더하기
        dfs(ind + 1, sum + numbers[ind], numbers, target); 
        // 현재 인덱스에 위치한 숫자를 빼기
        dfs(ind + 1, sum - numbers[ind], numbers, target);
    }
}