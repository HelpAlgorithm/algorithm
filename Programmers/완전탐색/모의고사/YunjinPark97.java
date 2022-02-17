class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int oneCorrect = 0;
        int twoCorrect = 0;
        int threeCorrect = 0;
        int[] oneAnswers = {1,2,3,4,5};
        int[] twoAnswers = {2,1,2,3,2,4,2,5};
        int[] threeAnswers = {3,3,1,1,2,2,4,4,5,5};
        
        for (int i = 0; i < answers.length; i++){
            if (answers[i] == oneAnswers[i%5]) oneCorrect++;
            if (answers[i] == twoAnswers[i%8]) twoCorrect++;
            if (answers[i] == threeAnswers[i%10]) threeCorrect++;
        }
        int maxCorrect = Math.max(Math.max(oneCorrect, twoCorrect), threeCorrect);
        int size = 0;
        
        // 극혐
        boolean oneFlag = false;
        boolean twoFlag = false;
        boolean threeFlag = false;
        if (oneCorrect == maxCorrect) {
            size++;
            oneFlag = true;
        }
        if (twoCorrect == maxCorrect)  {
            size++;
            twoFlag = true;
        }
        if (threeCorrect == maxCorrect)  {
            size++;
            threeFlag = true;
        }
        answer = new int[size];
        int idx = 0;
        if (oneFlag) answer[idx++] = 1;
        if (twoFlag) answer[idx++] = 2;
        if (threeFlag) answer[idx++] = 3;
        return answer;
    }
}