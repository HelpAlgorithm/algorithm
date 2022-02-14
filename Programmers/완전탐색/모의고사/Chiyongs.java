import java.util.*;

class Solution {

    static class Student {
        int idx;
        int count;

        public Student(int idx) {
            this.idx = idx;
            this.count = 0;
        }
    }

    public int[] solution(int[] answers) {
        int[] answer = {};

        int[] a = {1,2,3,4,5};
        int[] b = {2,1,2,3,2,4,2,5};
        int[] c = {3,3,1,1,2,2,4,4,5,5};

        Student sa = new Student(1);
        Student sb = new Student(2);
        Student sc = new Student(3);

        for(int i=0;i<answers.length;i++) {
            if(answers[i] == a[i%5]) {
                sa.count++;
            }
            if(answers[i] == b[i%8]) {
                sb.count++;
            }
            if(answers[i] == c[i%10]) {
                sc.count++;
            }
        }

        Student[] studs = {sa,sb,sc};

        Arrays.sort(studs, (o1, o2) -> o2.count - o1.count);
        answer = new int[3];

        if(studs[0].count == studs[1].count) {
            if(studs[1].count == studs[2].count) {
                answer[0] = 1;
                answer[1] = 2;
                answer[2] = 3;
                return answer;
            } else {
                answer[0] = studs[0].idx;
                answer[1] = studs[1].idx;

                int[] temp = {answer[0], answer[1]};
                Arrays.sort(temp);

                return temp;
            }
        } else {
            answer[0] = studs[0].idx;
            return Arrays.copyOf(answer, 1);
        }    
    }
}
