class Solution {

    static int[] answer;

    public int[] solution(int brown, int yellow) {
        answer = new int[2];

        outer:while(true) {
            int r = 0;
            int c = 0;
            for(int x=3;x<brown/2;x++) {
                for(int y=3;y<brown/2;y++) {
                    int result = 2*(x-1) + 2*(y-1);
                    int cnt = (y-2) * (x-2);
                    if(result == brown && cnt == yellow) {
                        answer[0] = y;
                        answer[1] = x;
                        break outer;
                    }
                }
            }

        }

        return answer;
    }
}
