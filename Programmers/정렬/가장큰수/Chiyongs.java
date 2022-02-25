import java.util.*;

class Solution { 

    static class MyNumber implements Comparable<MyNumber>{
        String value;
        int org;

        public MyNumber(String v,int org) {
            this.value = v;
            this.org = org;
        }

        // 비교하는 로직을 생각해내는 게 제일 힘들었다.
        @Override
        public int compareTo(MyNumber o) {
            return (o.value + this.value).compareTo(this.value + o.value);
        }
    }

    public String solution(int[] numbers) {
        String answer = "";

        int maxLen = 0;

        MyNumber[] temp = new MyNumber[numbers.length];

        for(int i=0,size=numbers.length;i<size;i++) {
            String str = String.valueOf(numbers[i]);            
            temp[i] = new MyNumber(str,numbers[i]);          
        }

        Arrays.sort(temp);

        for(int i=0,size=numbers.length;i<size;i++) {            
            answer = answer + String.valueOf(temp[i].org);
        }
        
        // 맨 앞이 '0'인 경우는 '0'만 계속 들어온 경우이다.
        if(answer.charAt(0) == '0') {
            return "0";
        }

        return answer;
    }
}