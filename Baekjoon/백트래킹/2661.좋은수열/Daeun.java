import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Daeun {
    /*  solution
     *  문자열 길이 N이라면, N/2 만큼 반복문을 돌려 숫자가 동일한지 서로 체크하면 된다.
     *  완탐을 하면서도, 중간에 나쁜 수열인것을 발견 -> 탐색 중단 => 백트래킹이 적합
     * */
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N= Integer.parseInt(br.readLine());
//        System.out.println("진입");
        findGood("");

    }
    private static void findGood(String str){
        if(str.length() ==N) { // 좋은 수열 완성
            System.out.println(str);
            System.exit(0);
        }
        for(int i=1;i<=3;i++) {
            if(isPossible(str+i)) {    // 이어 붙였을때 좋은 순열인 경우에만 진행시키기 (가지치기)
                findGood( str+i);
            }
        }
    }

    private static boolean isPossible(String str){    // 완성된 수열이 좋은 수열인지 판별
        //전체 길이의 반만 비교
        int mid = str.length() /2;
        int beginIndex = str.length() -1; // N-1 번째
        int endIndex = str.length(); // N번째
        for(int i=1; i<=mid; i++) { //1부터 mid까지만 비교
            if(str.substring(beginIndex-i, endIndex-i).equals(str.substring(beginIndex, endIndex))) return false;
            beginIndex -=1;
        }
        return true;
    }
}
