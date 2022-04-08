package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_S4_1439_뒤집기 {
    static int[] num;
    public static void main(String[] args) throws IOException {
        /* 풀이방법
        *  모든 숫자를 같게 만드려면
        * 1. 모두 0으로 만든다.
        * 2. 모두 1로 만든다.
        * 위의 두 경우
        * 즉 0과 1의 연속된 묶음의 갯수를 각각 COUNT한 뒤, 두 수를 비교해 '작은'값을 큰값의 숫자로 바꿔주면 된다 (최소변환으로 모든 숫자를 같게 만들기 위한 과정)
        * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        num = new int[str.length()];
        for(int i=0; i<str.length(); i++){
            num[i] = str.charAt(i)-'0';
        }

        int zero = 0;
        int one = 0;
        int curNum;
        
        // 연속 여부를 확인하기 위해 curNum에 첫 글자 저장
        curNum = num[0];

        //
        if(curNum == 0){
            zero = 1;
        }else{
            one = 1;
        }


        for(int i=1; i < num.length; i++){
            int cur = num[i];
            
            if(cur == curNum){
                continue; // 연속된 숫자
            }else if(cur == 0){ // 연속되지 않았으며 0 인 경우
                zero++;
            }else{
                one++;
            }
            // 연속여부 확인 갱신
            curNum = cur;
        }

        System.out.println(Math.min(zero, one));

    }
}
