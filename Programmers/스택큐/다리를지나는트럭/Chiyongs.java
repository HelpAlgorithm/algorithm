import java.io.*;
import java.util.*;

class Solution {

    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = new int[progresses.length];

        int idx = 0;
        int p = 0;

        boolean[] isComp = new boolean[progresses.length];
        while(true) {
            for(int i=p;i<progresses.length;i++) {
                progresses[i] += speeds[i];
                if(i==0 && progresses[i] >= 100) {
                    isComp[i] = true;
                    answer[idx]++;
                    p++;
                    continue;
                }
                if(progresses[i] >= 100 && isComp[i-1]) {
                    isComp[i] = true;
                    answer[idx]++;
                    p++;
                }
            }
            if(answer[idx] != 0) {
                idx++;
            }
            if(p==progresses.length) break;
        }


        return Arrays.copyOf(answer,idx);
    }
}
