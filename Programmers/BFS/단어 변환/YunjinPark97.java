import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        int targetIdx = 0;
        for (int i = 1; i <= words.length; i++){
            if (words[i-1].equals(target)) targetIdx = i;
        }
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= words.length+1; i++){
            graph.add(new ArrayList<>());
        }
        
        for (int i = 1; i <= words.length; i++){
            for (int j = 1; j <= words.length; j++){
                if (isNear(words[i-1], words[j-1])) graph.get(i).add(j);
            }
            if (isNear(words[i-1], begin)) graph.get(i).add(words.length+1);
        }
        
        for (int i = 1; i <= words.length; i++){
            if (isNear(begin, words[i-1])) graph.get(words.length+1).add(i);
        }
        
        boolean[] visited = new boolean[words.length+2];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(words.length+1);
        visited[words.length+1] = true;
        int depth = 0;
        outer: while (!queue.isEmpty()){
            int size = queue.size();
            depth++;
            while (size-- > 0){
                int cur = queue.poll();
                for (int nxt: graph.get(cur)){
                    if (visited[nxt]) continue;
                    if (nxt == targetIdx) {
                        answer = depth;
                        break outer;
                    }
                    visited[nxt] = true;
                    queue.offer(nxt);
                }
            }
        }
        return answer;
        
    }
    
    static boolean isNear(String str1, String str2){
        int cnt = 0;
        for (int i = 0; i < str1.length(); i++){
            if (str1.charAt(i) != str2.charAt(i)) cnt++;
        }
        return (cnt==1);
    }
}