import java.util.*;

public class Chiyongs {
	static class Ticket{
        String from, to;
        int idx;

        public Ticket (String from, String to, int idx) {
            this.from = from;
            this.to = to;
            this.idx = idx;
        }

    }

    static int max;
    static String[] airports;
    static String[] comp;
    public String[] solution(String[][] tickets) {        
        List<Ticket> tks = new ArrayList<>();

        for(int i=0;i<tickets.length;i++) {
            tks.add(new Ticket(tickets[i][0], tickets[i][1], i));
        }

        max = tks.size() + 1;
        airports = new String[max];

        for(int i=0;i<tickets.length;i++) {
            if(tks.get(i).from.equals("ICN")) {
            	// 인천에서 출발할 수 있는 경우마다 여행 시작
                String[] path = new String[max];
                path[0] = "ICN";
                boolean[] used = new boolean[max-1];
                used[tks.get(i).idx] = true;
                travel(tks.get(i), tks, 1, used, path);
            }            
        }

        return airports;
    }

    // dfs하면서 여행 경로 찾기
    private static void travel(Ticket tk, List<Ticket> tks, int cnt, boolean[] visited, String[] path) {
        if(cnt == max-1) {
            path[max-1] = tk.to;
            if(airports[0] == null) {
            	// 처음 만들어진 여행 경로일 때
                System.arraycopy(path, 0, airports, 0, max);
                return;
            }

            if(comparePath(airports, path)) {
            	// 오름차순 비교를 하니 현재 완성된 경로가 더 적합할 경우
                System.arraycopy(path, 0, airports, 0, max);
            }
            return;
        }

        for(int i=0;i<tks.size();i++) {
            if(visited[i]) continue;
            if(tk.to.equals(tks.get(i).from)) {
                visited[i] = true;
                path[cnt] = tks.get(i).from;
                travel(tks.get(i), tks, cnt+1, visited, path);
                visited[i] = false;
                path[cnt] = "";
            }
        }
    }

    // 여행 경로들 중 오름차순이 가장 빠른 여행경로를 찾기 위해
    // 직전에 가본 여행 경로와 현재 완성된 여행 경로를 비교하는 메서드
    private static boolean comparePath(String[] path1, String[] path2) {        
        for(int i=0;i<max;i++) {
            if(path1[i].equals(path2[i])) continue;
            else {
                int co = path1[i].compareTo(path2[i]);
                if(co >= 1) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}