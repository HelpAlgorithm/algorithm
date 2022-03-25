package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_S3_2193_이친수 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] DP = new long[N+1];

        DP[0] = 0;
        DP[1] = 1;
        for (int i=2; i<=N; i++) {
            DP[i] = DP[i-1] + DP[i-2];
        }

        System.out.println(DP[N]);
    }

}


