import java.util.*;

class Solution {
	// 프로그래머스 - 여행경로
	static ArrayList<String> answer;
	static boolean [] visited;  //방문 여부 체크
    
	public String[] solution(String[][] tickets) {
		answer = new ArrayList<>(); 
		visited = new boolean[tickets.length+1];
        
		String ans = "ICN ";
		dfs("ICN",tickets,ans,1);
		Collections.sort(answer);
        
//         System.out.println(answer.toString());
		return answer.get(0).split(" "); 
	}
	private static void dfs(String start, String[][] tickets, String ans,int idx) {
		if(idx==tickets.length+1) { // 전부 다 방문한 경우 종료
			answer.add(ans);
			return;
		}
		for(int i=0;i<tickets.length;i++) {
			if(!visited[i] && start.equals(tickets[i][0])) {    // 방문한 적 없고 + 현재 위치한 항공 == 티켓의 시작 항공 일 때만 다음 dfs로 이동
				visited[i] = true;  // 방문 처리
				dfs(tickets[i][1], tickets, ans+tickets[i][1]+" ", idx+1);
				visited[i] = false;
			}
		}
	}
}