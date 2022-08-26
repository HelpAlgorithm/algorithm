import java.util.*;

class Solution {
    public int solution(String[] lines) {
        int N = lines.length;
        List<Integer> starts = new ArrayList<>();
        List<Log> logs = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(lines[i], " ");
            st.nextToken();
            String[] times = st.nextToken().split(":");
            int endTime = Integer.parseInt(times[0])*3600000 + Integer.parseInt(times[1])*60000
                            + (int) (Double.parseDouble(times[2]) * 1000);
            String temp = st.nextToken();
            temp = temp.substring(0, temp.length()-1);
            int interval = (int) (1000 * Double.parseDouble(temp));
            int startTime = endTime - interval + 1;
            starts.add(startTime);
            logs.add(new Log(startTime, endTime));
        }

        int answer = 0;
        // 시작점에 들어가는 순간만 세면 된다.
        for (int start: starts) {
            int cnt = 0;
            for (Log log: logs) {
                if ((start - 999 <= log.start && log.start <= start) 
                        || (start - 999 <= log.end && log.end <= start)) {
                    cnt++;
                } else if (log.start < start - 999 && start < log.end) {
                    cnt++;
                }
            }
            answer = Math.max(answer, cnt);
        }
        return answer;
    }

    static class Log {
        int start;
        int end;

        public Log(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}