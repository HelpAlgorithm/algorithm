class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] temp = new int[100]; // 임시로 정답 저장
        int[] days = new int[progresses.length]; // 며칠 후 배포 가능한지
        
        // 배포 가능 날짜 계산
        for(int i = 0; i < progresses.length; i++) {
            days[i] = (99 - progresses[i]) / speeds[i] + 1;
        }
        
        int cnt = 1; // 한번에 배포 가능한 개수
        int day = days[0]; // 현재 배포하는 작업의 배포일
        int ind = 0; // 정답 개수
        for(int i = 1; i < days.length; i++) {
            if(days[i] > day) {
                temp[ind++] = cnt;
                day = days[i];
                cnt = 1;
            } else {
                cnt++;
            }
        }
        temp[ind++] = cnt;
        
        // 정답 옮기기 <- 이 부분이 Arrays.copyof() 를 사용하지 못해서 찾아봄
        int [] answer = new int[ind];
        for(int i = 0; i < ind; i++) {
            answer[i] = temp[i];
        }
        
        return answer;
    }
}
