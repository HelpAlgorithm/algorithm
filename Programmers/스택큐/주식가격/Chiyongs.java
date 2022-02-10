class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i=0;i<prices.length;i++) {
            for(int j=i+1;j<prices.length;j++) {
                if(prices[i] <= prices[j]) {
                    answer[i]++;
                }
                else {
                	// 주가가 떨어졌어도 1초간 유지된 것이므로
                    answer[i]++;
                    break;
                }
            }
            if(i==prices.length-1) {
                answer[i] = 0;
            }
        }

        return answer;
    }
}