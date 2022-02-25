import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);	// 오름차순으로 정렬 -> ex. 0 1 3 5 6
        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;	// 반복할 때마다 h의 값이 1씩 줄어들도록 함
            if (citations[i] >= h) {	// citations.length (== n)편 중,  h번 이상 인용된 논문이 h편 이상이고 , 나머지 논문이 h번 이하로 인용되었는지 체크
                answer = h;
                break;	// h는 줄어들기만 하기 때문에 해당 조건을 처음 만족하면 -> 해당 값이 최댓값(== H-index)
            }
        }
        return answer;
    }
}

    