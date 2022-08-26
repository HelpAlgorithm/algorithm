import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            answer[i] = numToStr(arr1[i] | arr2[i], n);
        }
        return answer;
    }

    static String numToStr(int num, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (num % 2 == 1) sb.append("#");
            else sb.append(" ");
            num /= 2;
        }
        sb.reverse();
        return sb.toString();
    }
}