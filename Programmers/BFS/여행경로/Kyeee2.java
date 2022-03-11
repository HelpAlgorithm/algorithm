import java.util.*;

class Solution {
    int N; // 총 방문해야하는 도시의 개수
    boolean flag = true; // 최초 방문 성공하였는가?
    String[] answer; // 정답
    List<String> temp = new ArrayList<>(); // 경로 임시 저장
    boolean [] visited = new boolean[10000]; // 방문 체크
    
    public String[] solution(String[][] tickets) {
        N = tickets.length;
        answer = new String[N + 1];
        
        // tickets 오름차순으로 정렬
        Arrays.sort(tickets, (t1, t2) -> {
            if(t1[0].equals(t2[0])) {
                return t1[1].compareTo(t2[1]);
            } else {
                return t1[0].compareTo(t2[0]);
            }
        });
        
        temp.add("ICN");
        DFS("ICN", tickets, 0);
        
        return answer;
    }
    
    private void DFS(String city, String[][] tickets, int cnt) { // city: 출발지
        if(cnt == N) {
            if(flag) { // 제일 처음 찾은 경로가 정답
                for(int i = 0; i < N + 1; i++) {
                    answer[i] = temp.get(i);
                }
                flag = false;
            }
            return;
        }
        
        for(int i = 0; i < N; i++) {
            // 출발지가 동일하고, 아직 방문하지 않았다면
            if(tickets[i][0].equals(city) && !visited[i]) {
                visited[i] = true;
                temp.add(tickets[i][1]);
                DFS(tickets[i][1], tickets, cnt + 1);
                temp.remove(temp.size() - 1); // 마지막에 추가한거 삭제하기
                visited[i] = false;
            }
        }
    }
}