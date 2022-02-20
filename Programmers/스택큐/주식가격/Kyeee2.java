import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[prices.length];
        
        for(int i = prices.length - 1; i >= 0; i--) {
            while(!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                stack.pop();
            }
            
            if(stack.isEmpty()) {
                answer[i] = prices.length - 1 - i;
            } else {
                answer[i] = stack.peek() - i;
            }
            
            stack.push(i);
        }
        
        return answer;
    }
}