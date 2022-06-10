package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_G4_17779_게리맨더링2 {
    static int[][] map;
    static int N,total; // 시 크기, 인구수 총합(5구역 계산에 이용)
    static int answer =Integer.MAX_VALUE;
    static int[] people = new int[6]; // 구역별 인구수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 입력 처리
        N = Integer.parseInt(br.readLine());
        map=new int[N +1][N +1];

        for(int i = 1; i<= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<= N; j++) {
                map[i][j]= Integer.parseInt(st.nextToken());
                total+=map[i][j];
            }
        }

        // solution
        // x,y,d1,d2 모든 경우의 수 탐색
        for(int x = 1; x <= N; x++) {
            for(int y = 1; y <= N; y++) {
                for(int d1 = 1; d1 <= N; d1++) {
                    for(int d2 = 1; d2 <= N; d2++) {
                        // 범위 처리
                        if(x + d1 + d2> N) continue; // (x+d1+d2 ≤ N) 처리
                        if(y - d1 <= 0 || y + d2> N) continue;  // (1 ≤ y-d1), (y+d2 ≤ N) 처리
                        solution(x, y, d1, d2);
                    }
                }
            }
        }
        // output
        System.out.println(answer);
    }
    static void solution(int x, int y, int d1, int d2) {
        // 5구역 + 경계선까지 체크해둘 배열
        boolean[][] isFive = new boolean[N +1][N +1];

         // 5구역 체크
         // 1. (x, y), (x+1, y-1), ..., (x+d1, y-d1)
         // 4. (x+d2, y+d2), (x+d2+1, y+d2-1), ..., (x+d2+d1, y+d2-d1)
        for(int i = 0; i <= d1; i++) {
            isFive[x+i][y-i] = true;
            isFive[x+d2+i][y+d2-i] = true;
        }
        // 2. (x, y), (x+1, y+1), ..., (x+d2, y+d2)
        // 3. (x+d1, y-d1), (x+d1+1, y-d1+1), ... (x+d1+d2, y-d1+d2)
        for(int i = 0; i <= d2; i++) {
            isFive[x+i][y+i] = true;
            isFive[x+d1+i][y-d1+i] = true;
        }

        // 1구역 인구 수 1 ≤ r < x+d1, 1 ≤ c ≤ y
        for(int i = 1; i < x+d1; i++) {
            for(int j = 1;j <= y; j++) {
                if(isFive[i][j]) break;
                people[1] += map[i][j];
            }
        }

        // 2구역 인구 수  1 ≤ r ≤ x+d2, y < c ≤ N
        for(int i = 1; i <= x+d2; i++) {
            for(int j = N; j > y; j--) {
                if(isFive[i][j]) break;
                people[2]+=map[i][j];
            }
        }

        // 3구역 인구 수 x+d1 ≤ r ≤ N, 1 ≤ c < y-d1+d2
        for(int i = x+d1; i<= N; i++) {
            for(int j=1;j<y-d1+d2;j++) {
                if(isFive[i][j]) break;
                people[3]+=map[i][j];
            }
        }

        // 4구역 인구 수 x+d2 < r ≤ N, y-d1+d2 ≤ c ≤ N
        for(int i = x+d2+1; i<= N; i++) {
            for(int j = N; j>=y-d1+d2; j--) {
                if(isFive[i][j]) break;
                people[4]+=map[i][j];
            }
        }

        // 5구역의 인구수 전체 인구수 - 다른 구역의 인구수
        people[5]=total;
        for(int i=1;i<=4;i++)
            people[5]-=people[i];



        Arrays.sort(people); // 정렬 후 차이 최댓값 구하기
        answer = Math.min(answer, people[5]-people[1]);
    }
}
