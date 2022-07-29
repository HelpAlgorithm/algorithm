package boj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author chiyongs
 * @since 2022. 7. 5.
 * @see https://www.acmicpc.net/problem/2661
 * @performance 32796	228
 * @category #백트래킹
 * @note열 문자열 처음부터 앞과 뒤를 다 비교하지 않고 맨 뒤부터 길이만큼만 비교해도 됨...
 */
public class BOJ_G4_2661_좋은수열 {

    static int N;
    static boolean[] isSelected;
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        isSelected = new boolean[N + 1];
        answer.append(1);
        choose(1);
    }

    static void choose(int cnt) {
        if (cnt == N) {
            System.out.println(answer);
            System.exit(0);
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (answer.charAt(answer.length() - 1) != ('0' + i)) {
                answer.append(i);
                if (validate(answer.toString())) {
                    choose(cnt + 1);
                }
                answer.deleteCharAt(answer.length() - 1);
            }
        }
    }

    static boolean validate(String str) {
        for(int length = 2;length<=str.length()/2;length++) {
            int start = 0;
            int end = start + length;
            while(end < str.length()) {
                StringBuilder sb = new StringBuilder();
                for(int i=start;i<end;i++) {
                    sb.append(str.charAt(i));
                }

                if(!compareFoward(sb.toString(), str, start) || !compareBack(sb.toString(), str, start)) {
                    return false;
                }
                start++;
                end++;
            }
        }
        return true;
    }

    static boolean compareBack(String comp, String original, int start) {
        if(start + comp.length() + comp.length() <= original.length() ) {
            int compIndex = 0;
            for(int i=start+comp.length();i<start+(2*comp.length());i++,compIndex++) {
                if(original.charAt(i) != comp.charAt(compIndex)) return true;
            }
            return false;
        }
        return true;
    }

    static boolean compareFoward(String comp, String original, int start) {
        if(start - comp.length() >= 0) {
            int compIndex = 0;
            for(int i=start-comp.length();i<start;i++,compIndex++) {
                if(original.charAt(i) != comp.charAt(compIndex)) return true;
            }
            return false;
        }
        return true;
    }

}
