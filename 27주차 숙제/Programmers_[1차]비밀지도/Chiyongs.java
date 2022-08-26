package programmers.카카오.블라인드채용2018.비밀지도;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for(int i=0;i<n;i++) {
            String first = Integer.toBinaryString(arr1[i]);
            String second = Integer.toBinaryString(arr2[i]);

            while(first.length() < n) {
                first = "0" + first;
            }

            while(second.length() < n) {
                second = "0" + second;
            }

            StringBuilder sb = new StringBuilder();

            for(int j=0;j<n;j++) {
                char f = first.charAt(j);
                char s = second.charAt(j);

                if(f == s) {
                    if(f == '0')
                        sb.append(" ");
                    else
                        sb.append("#");
                } else {
                    sb.append("#");
                }
            }

            System.out.println(sb);
            answer[i] = sb.toString();
        }

        return answer;
    }
}