import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int size = citations.length;
        Integer [] citations_copy = new Integer[size];
        for(int i = 0; i < size; i++) {
            citations_copy[i] = citations[i];
        }
        Arrays.sort(citations_copy, (n1, n2) -> Integer.compare(n1, n2) * -1);
        
        if(citations_copy[0] == 0) return 0;
        
        for(int i = 0; i < size; i++) {
            if(citations_copy[i] <= i) {
                return i;
            }
        }
        
        return size; // 이 문제는 이해가 안된다...
    }
}