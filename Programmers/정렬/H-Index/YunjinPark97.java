import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
		List<String> list = new ArrayList<>();
		for (int i = 0; i < numbers.length; i++) {
			list.add(Integer.toString(numbers[i]));
		}
		
		Collections.sort(list, (o1, o2)->{
			return -(o1+o2).compareTo(o2+o1); 
		});
		
        if (list.get(0).charAt(0) == '0') return "0";
		for (int i = 0; i < list.size(); i++) {
			answer += list.get(i);
		}
		return answer;

	}

}