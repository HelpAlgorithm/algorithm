import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] cnts = new int[N+1];
        for (int stage: stages) {
            if (stage > N) continue;
            cnts[stage]++;
        }
        int num = stages.length; // 사람 수
        List<Failure> fails = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (cnts[i] == 0 || num == 0) {
                fails.add(new Failure(i, 0));
            }
            else {
                fails.add(new Failure(i, (double) cnts[i] / num));
                num -= cnts[i];
            }
        }
        Collections.sort(fails);
        
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = fails.get(i).stage;
        }
        return answer;
    }
    
    static class Failure implements Comparable<Failure>{
        int stage;
        double fail;
        
        public Failure(int stage, double fail) {
            this.stage = stage;
            this.fail = fail;
        }
        
        public int compareTo(Failure o) {
			if (this.fail == o.fail) {
                return Integer.compare(this.stage, o.stage);
            }
            return - Double.compare(this.fail, o.fail);
        }
    }
}