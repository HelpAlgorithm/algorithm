package boj.b2;

import java.util.Scanner;
/**
 * @author chiyongs
 * @since 2022. 8. 12
 * @see https://www.acmicpc.net/problem/13410
 * @performance 13820	124
 * @category #완전탐색
 * @note
 */
public class BOJ_B2_13410_거꾸로구구단 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int max = 0;
        int maxLen = 1;
        for(int i=K;i>=1;i--) {
            int num = N*i;
            int len = String.valueOf(num).length();
            if(len < maxLen) break;
            int result = reverse(num);
            if(max < result) max = result;
        }
        System.out.println(max);
    }

    private static int reverse(int num) {
        String tmp = String.valueOf(num);
        String reverseNum = "";
        for(int i=tmp.length()-1;i>=0;i--) {
            reverseNum += tmp.charAt(i);
        }
        return Integer.parseInt(reverseNum);
    }
}
