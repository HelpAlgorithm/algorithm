import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Stack<Integer> stack = new Stack<Integer>();
        int[] answer = new int[prices.length];

        int temp;
        for (int second = 0; second < prices.length; second++){
            while (!stack.empty() && prices[stack.peek()] > prices[second]){
                temp = stack.pop();
                answer[temp] = second - temp;
            }
            stack.push(second);
        }
        while (!stack.empty()){
            temp = stack.pop();
            answer[temp] = prices.length - temp - 1;
        }
        return answer;
    }
}