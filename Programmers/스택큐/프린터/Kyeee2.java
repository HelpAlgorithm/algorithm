import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {        
        Queue<Priority> Q = new LinkedList<>();
        Queue<Priority> temp = new LinkedList<>();
        
        for(int i = 0; i < priorities.length; i++) {
            Q.offer(new Priority(i, priorities[i])); // .add()와 동일
        }
        
        int cnt = 0;
        while(true) {
            Priority front = Q.poll(); // .remove()와 동일
            
            if(Q.isEmpty()) {
                cnt++;
                break;
            }
            
            boolean flag = true; // 가장 앞에 있는 문서가 가장 높은 중요도를 가지고 있는가 
            while(!Q.isEmpty()) {
                Priority p = Q.peek();
                if(p.impor > front.impor) {
                    flag = false;
                    break;
                }
                p = Q.poll();
                temp.offer(p);
            }
            
            if(flag) {
                cnt++;
                if(front.loc == location) {
                    break;
                }                
            } else {
                Q.offer(front);
            }
            
            while(!temp.isEmpty()) {
                Q.offer(temp.poll());
            }            
        }
        
        return cnt;
        
    }
}

class Priority {
    int loc;
    int impor;
    
    public Priority(int loc, int impor) {
        this.loc = loc;
        this.impor = impor;
    }
}