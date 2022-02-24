import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        int size = numbers.length;
        String [] nums = new String[size];
        for(int i = 0; i < size; i++) {
            nums[i] = numbers[i] + "";
        }
        Arrays.sort(nums, (n1, n2) -> (n1 + n2).compareTo(n2 + n1) * -1);
        // 3, 30 일 때, 330이 큰지 303이 큰지 판단!
        
        if(nums[0].equals("0")) return "0"; // 가장 큰 값이 0 인 경우 0000이 아닌 0 으로 출력
        
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < size; i++) {
            answer.append(nums[i]);
        }
        
        return answer.toString();
    }
}