import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0, max = 0;        
        Arrays.sort(citations);        

        int h = 0;
        int size = citations.length;
        while(true) {
            int cnt = 0;
            for(int i=0;i<size;i++) {
                if(citations[i] >= h) {
                    cnt++; // h번 이상 인용된 논문 갯수
                }
            }
            if(cnt < h) break; // h번 이상 인용된 논문 갯수가 h보다 작으면 조건 불충족
            // h번 이상 인용된 논문이 h편 이상이어야 함!

            if(cnt >= h && size-cnt <= h) {
            	// h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용인 경우
                if(max < h) {
                    max = h; // max값 갱신
                }
            }
            h++;
        }
        answer= max;
        return answer;
    }
}