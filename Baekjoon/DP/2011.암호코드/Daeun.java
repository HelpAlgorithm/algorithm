package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_G4_2011_암호코드 {
    /* 이거 문제 난이도 왜이럼..... 이해하기 힘들었음...ㅠ */

    /* 풀이 방법
    *  DP[i] : 0 번째부터 i번째 글자 까지 암호 해석 가능한 숫자
    *  DP[0] : 1 (한글자씩 쪼개야 하므로)
    *  
    *  num[i]가 0 이라면 (i는 1의자리에만 올 수 있다. 10의자리는 불가능)
    *  num[i-1] 은 1 또는 2 => 2 가지 경우만 존재
    *  또한 i가 0 인 순간 두개를 묶어야 하기 때문에 
    *  ==> DP[i] = DP[i-2] 성립
    *
    * 위의 경우가 아니라면
    *  DP[i] = DP[i-1] + DP[i-2]; 성립
     *
    * 숫자 범위 -> 1 ~ 26 까지만 해석 가능
    * 즉, 10의 자리 : 1 또는 2 만 가능  + 1의 자리 : (10의 자리가 1인 경우 - 1 ~ 9) + (10의 자리가 2인 경우 - 1 ~ 6) 만 가능
    * => 나머지 값들이 들어온 경우 -> 해석 불가능
    *
    * 어려웠던 부분 : input이 0으로 시작하는 숫자가 들어오는 경우(아얘 불가능함) + 1000000 으로 DP에 넣기전에 꼭 나눠줘야한다는것을 놓쳐서 시간 엄청 날렸다...
    * */

    static int[] num;
    static int[] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        num = new int[str.length()+1];
        DP = new int[str.length()+1];
        int result = -1;
        DP[0] = 1;

        // input
        for(int i=1; i<=str.length(); i++){
            num[i] = str.charAt(i-1)-'0';
        }

        // 풀이
        if(num[1] == 0){ // 첫글자 0 -> 해독 불가능
            result = 0;
        }else{
            DP[1] = 1;

            for(int i=2; i<=str.length(); i++){
                if(num[i] == 0) {// i번째 숫자가 0인 경우
                    if (num[i - 1] == 1 || num[i - 1] == 2) { //i-1번째 숫자는 1 또는 2여야만 해독 가능함
                        DP[i] = DP[i - 2] % 1000000;
                    } else {// 해독 불가능
                        result = 0;
                        break;
                    }
                }else{// i번째 숫자가 1 ~ 9 인 경우
                    if(num[i-1] == 1){ //i-1 번째 숫자가 1인 경우 -> (i번째 숫자 1 ~ 9 전부 가능)
                        DP[i] = (DP[i-1] + DP[i-2]) % 1000000; // 범위 초과가 날 수 있으므로 연산 하면서 나머지만 넘기기
                    }else if(num[i-1] == 2 && (num[i] >= 1 && num[i] <= 6)){ //i-1 번째 숫자가 2인 경우 -> (i번째 숫자 1 ~ 6만 가능)
                        DP[i] = (DP[i-1] + DP[i-2]) % 1000000; // 위와 동일
                    }else{
                        DP[i] = DP[i-1]; // 해당 위치는 해독 불가능 -> 이전 값만 넘겨받기
                    }
                }
            }
        }

        // output
        System.out.println((result == 0)? result : DP[str.length()]); // 0이 반환되었으면 변환 불가능 -> 아니라면 DP[마지막 글자의 index] 출력

    }
}
