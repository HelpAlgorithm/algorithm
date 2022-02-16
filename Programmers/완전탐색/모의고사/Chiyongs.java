import java.util.*;

class Solution {

    static class Student {
        int idx; // 정렬했을 때 몇번 수포자인지 알기 위한 idx
        int count;  // 정답을 맞춘 갯수

        public Student(int idx) {
            this.idx = idx;
            this.count = 0;
        }
    }

    public int[] solution(int[] answers) {
        int[] answer = {};

        int[] a = {1,2,3,4,5}; // 5번마다 동일한 규칙
        int[] b = {2,1,2,3,2,4,2,5}; // 8번마다 동일한 규칙
        int[] c = {3,3,1,1,2,2,4,4,5,5}; // 10번마다 동일한 규칙

        Student sa = new Student(1);
        Student sb = new Student(2);
        Student sc = new Student(3);

        for(int i=0;i<answers.length;i++) { // 정답을 맞추면 count++
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

        // 정답을 많이 맞춘 순서로 정렬
        Arrays.sort(studs, (o1, o2) -> o2.count - o1.count);
        answer = new int[3];

        if(studs[0].count == studs[1].count) {
            if(studs[1].count == studs[2].count) {
            	// 세 명이 다 동일한 점수일때
                answer[0] = 1;
                answer[1] = 2;
                answer[2] = 3;
                return answer;
            } else {
            	// 가장 높은 점수가 두 명일때
                answer[0] = studs[0].idx;
                answer[1] = studs[1].idx;

                int[] temp = {answer[0], answer[1]};
                Arrays.sort(temp);

                return temp;
            }
        } else {
        	// 가장 높은 점수가 한 명일때
            answer[0] = studs[0].idx;
            return Arrays.copyOf(answer, 1);
        }    
    }
}
