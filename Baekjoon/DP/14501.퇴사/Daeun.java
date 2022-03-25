package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_S3_14501_퇴사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int T[] = new int[N+1];
        int P[] = new int[N+1];
        int DP[] = new int[N+2];

        for(int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            T[i]= Integer.parseInt(st.nextToken());
            P[i]= Integer.parseInt(st.nextToken());
        }

        for(int i=N;i>0;i--) {
            int index=i+T[i];

            if(index >N+1)
                DP[i]=DP[i+1];
            else
                DP[i]=Math.max(DP[i+1],P[i]+DP[index]);

        }
        System.out.println(DP[1]);
    }
}