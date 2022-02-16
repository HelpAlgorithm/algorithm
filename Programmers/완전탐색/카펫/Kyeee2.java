class Solution {
    public int[] solution(int brown, int yellow) {
        int n = 0, m = 0;
        
        for(n = 1; n * n <= yellow; n++) {
            if(yellow % n != 0) continue;
            
            m = yellow / n;
            if((n + m) * 2 + 4 == brown) break;
        }
        
        int[] answer = {m + 2, n + 2};
        
        return answer;
    }
}