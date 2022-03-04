class Solution {
    
    int answer = Integer.MAX_VALUE;
    boolean [] visited;
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        dfs(0, begin, target, words);
        
        if(answer == Integer.MAX_VALUE) return 0; // 변환할 수 없는 경우
        return answer;
    }
    
    private void dfs(int cnt, String begin, String target, String[] words) {
        if(begin.equals(target)) {
            answer = Math.min(answer, cnt);
            return;
        }
        
        for(int i = 0; i < words.length; i++) {
            if(visited[i]) continue;
            
            int cnt_diff = 0; // 몇 글자가 다른지
            for(int j = 0; j < begin.length(); j++) {
                if(begin.charAt(j) != words[i].charAt(j)) cnt_diff++;
            }
            
            // 한 글자만 변환할 수 있는 경우
            if(cnt_diff == 1) {
                visited[i] = true;
                dfs(cnt + 1, words[i], target, words);
                visited[i] = false;
            }
        }
    }
}