package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_S2_14889_스타트와링크 {
    static int N;
    static int min = Integer.MAX_VALUE;
    static int[][] arr;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // input
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        isVisited = new boolean[N];  // true : start팀 false : link팀으로 구분
    
        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; st.hasMoreTokens();j++) {
                arr[i][j]= Integer.parseInt(st.nextToken());
            }
        }

        // simulation
        dfs(0,0);
        // output
        System.out.println(min);
    }
    public static void dfs(int depth, int a) {
        if(depth == N/2) {  // 팀 나누기 끝
            calculate();
            return;
        }
        for(int i = a ; i < N ; i++) {
            isVisited[i]=true;  // 선택하고
            dfs(depth+1, i+1);
            isVisited[i]=false; // 선택하지 않고
        }
    }

    public static void calculate() {
        int start = 0;  // start팀 시너지
        int link = 0;   // link팀 시너지

        // 시너지 계산
        for(int i = 0 ; i < N-1 ; i++) {
            for(int j = i+1 ; j < N ; j++) {
                if(isVisited[i]==true && isVisited[j]==true) {  // i 랑 j가 start 팀인 경우
                    start += arr[i][j];
                    start += arr[j][i];
                }
                else if(isVisited[i]==false && isVisited[j]==false) {   // i랑 j가 link팀인 경우
                    link += arr[i][j];
                    link += arr[j][i];
                }

            }
        }

        int val = Math.abs(start - link);

        if(val == 0) {  // 차이가 0 -> 이보다 더 적을수는 없다 ! -> 즉 더이상 할 필요조차 없음 종료
            min = val;
            return;
        }
        min=Math.min(min,val);
    }


}
