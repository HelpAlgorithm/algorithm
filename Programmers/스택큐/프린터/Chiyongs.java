import java.util.*;

class Solution {

    static class Document {
        int priority;
        int location;

        public Document(int priority, int location) {
            this.priority = priority;
            this.location = location;
        }
    }   

    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Document> q = new LinkedList<>();

        for(int i=0;i<priorities.length;i++) {
            q.offer(new Document(priorities[i], i));
        }

        int cnt = 0;
        while(!q.isEmpty()) {            
            Document temp = q.poll();
            for(Document d: q) {
                if(d.priority > temp.priority) {
                    q.offer(temp);
                    temp=null;
                    break;
                }
            }
            if(temp!=null) {
                cnt++;
                if(temp.location == location) {
                    return cnt;
                }
            }

        }
        answer = cnt;
        return answer;
    }
}
