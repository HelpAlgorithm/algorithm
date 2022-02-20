import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer;
        
        int[] person1 = {1,2,3,4,5}; 
        int[] person2 = {2,1,2,3,2,4,2,5};
        int[] person3 = {3,3,1,1,2,2,4,4,5,5};
        int s1 = 0;
        int s2 = 0;
        int s3 = 0;
        
         for( int i=0; i< answers.length; i++){ // 점수 채점
            // 1번
            if ( answers[i] == person1[ i % 5 ]) s1++;
            // 2번
            if ( answers[i] == person2[ i % person2.length ]) s2++;
            // 3번
            if ( answers[i] == person3[ i % 10 ]) s3++;
        }

        int max = 0;
                
        if(s1 > s2){
            if(s1 > s3){
                answer = new int[] {1};
            }else if(s1 == s3){
                answer = new int[] {1,3};
            }else{
                answer = new int[] {3};                
            }
        }else if(s1 == s2){
            if(s1 > s3){
                answer = new int[] {1,2};
            }else if(s1 == s3){
                answer = new int[] {1,2,3};
            }else{
                answer = new int[] {3};                
            }
        }else{ // s1 < s2
           if(s2 > s3){
                answer = new int[] {2};
            }else if(s2 == s3){
                answer = new int[] {2,3};
            }else{
                answer = new int[] {3};                
            } 
        }

        return answer;
    }
}