package programmers.카카오인턴.수식최대화;

import java.util.*;

class Solution {

    static int[][] priorities = {{0,1,2},{0,2,1},{1,0,2},{1,2,0},{2,0,1},{2,1,0}};
    static List<Long> nums;
    static List<Character> operators;

    public long solution(String expression) {
        long answer = 0;

        // 가능한 우선순위를 다 구한다.
        for(int[] priority : priorities) {
            nums = new ArrayList<>();
            operators = new ArrayList<>();
            String num = "";

            // 연산자와 피연산자를 모두 분리해서 넣어둔다.
            for(int i=0;i<expression.length();i++) {
                char c = expression.charAt(i);
                if(c == '+' || c == '-' || c == '*') {
                    operators.add(c);
                    nums.add(Long.parseLong(num));
                    num = "";
                }
                else {
                    num += c;
                }
            }

            // 마지막 피연산자도 넣어준다.
            nums.add(Long.parseLong(num));


            for(int i=0;i<3;i++) {
                char operator = 'a';
                if(priority[i] == 0) operator = '+';
                else if(priority[i] == 1) operator = '-';
                else operator = '*';

                // 연산해야할 연산자가 남아있을 때까지 반복
                while(operators.size() > 0) {

                    int index = operators.indexOf(operator);

                    // 연산해야할 연산자가 남아있지만, 지금 우선순위의 연산자는 존재하지 않을 때
                    if(index == -1) break;

                    Long result = calculate(nums.get(index), nums.get(index+1), operator);

                    // index 위치를 remove하면, index+1에 있던 값이 index자리로 오기 때문에 index 자리를 두 번 remove
                    nums.remove(index);
                    nums.remove(index);
                    nums.add(index, result);
                    operators.remove(index);

                }
            }

            answer = Math.max(answer, Math.abs(nums.get(0)));
        }

        return answer;
    }


    static Long calculate(Long A, Long B, char operand) {
        if(operand == '+') return A+B;
        else if(operand == '-') return A-B;
        else return A*B;
    }
}