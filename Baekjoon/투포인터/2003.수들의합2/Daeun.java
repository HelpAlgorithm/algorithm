package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_S3_2003_수들의합2 {
    static int N, M, sum, start, end, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while(true){
            if(sum>=M){
                sum-=arr[start++];
            }
            else if(end==N){
                break;
            }else{
                sum+=arr[end++];
            }

            if(sum==M){
                count++;
            }
        }
        System.out.println(count);

    }
}
