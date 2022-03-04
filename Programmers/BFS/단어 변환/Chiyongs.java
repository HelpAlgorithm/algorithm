import java.util.*;
class Solution {

    static class Word {
        String value;
        int count;

        public Word(String value, int count) {
            this.value = value;
            this.count = count;
        }
    }

    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        int[] visited = new int[words.length];
        int std_len = begin.length();
        Word start = new Word(begin, 0);
        boolean isContain = false;
        int idx = 0;
        for(int i=0;i<words.length;i++) {
            if(words[i].equals(target)) {
                isContain=true;
                idx = i;
            }
        }

        if(isContain) {
            Queue<Word> Q = new LinkedList<>();
            Q.offer(start);        
            while(!Q.isEmpty()) {
                Word cur = Q.poll();

                for(int i=0;i<words.length;i++) {
                    if(visited[i] != 0) continue;
                    int cnt = 0;
                    for(int j=0;j<std_len;j++) {
                        if(cur.value.charAt(j) == words[i].charAt(j)) cnt++;
                    }
                    if(cnt != std_len-1) continue;

                    visited[i] = cur.count+1;
                    Q.offer(new Word(words[i], cur.count+1));
                }
            }
            answer = visited[idx];
        }        

        return answer;
    }
}