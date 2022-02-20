class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int mul = brown + yellow;
        int sum = (brown + 4) / 2;
        for (int i = 1; i <= Math.pow(mul, 0.5); i++){
            if (mul % i != 0) continue;
            if (mul/i + i == sum) {
                answer[0] = mul/i;
                answer[1] = i;
                break;
            }
        }
        return answer;
    }
}