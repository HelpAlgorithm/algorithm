package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_G3_14890_경사로 {
    static int[][] map;
    static int N, L, result;    //  크기 , 연속칸 ,  지나갈 수 있는 길의 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        // input 처리
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // row, col 별로 나누어 지나갈 수 있는지 검사
        int[] col = new int[N];
        int[] row = new int[N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                row[j] = map[j][i]; // row만 저장
                col[j] = map[i][j]; // col만 저장
            }

            // solve
            if(isPossible(col)) result++;    // col
            if(isPossible(row)) result++;    // row
        }
        System.out.println(result);
    }

    // 경사로가 설치 가능하다면 true, 아니면 false 반환
    public static boolean isPossible(int[] arr) {
        boolean[] visited = new boolean[N]; // 경사로의 설치 여부 판단

        for(int i = 1; i < N; i++) {
            if(arr[i] == arr[i-1]) { // 높이가 같으면 pass 
                continue;
            } else if(arr[i] - arr[i-1] == 1) { // (왼쪽 < 오른쪽) 높이차이가 1인 경우
                for(int j = i-1; j >= i-L; j--) { // 현재 i칸 이전의 칸들 L만큼 검사 
                    // 범위를 벗어나고, 높이가 다르고, 경사로가 있는 곳이라면 실패 
                    if(j < 0 || arr[j] != arr[i]-1 || visited[j]) {
                        return false;
                    }
                    visited[j] = true;
                }
            } else if(arr[i] - arr[i-1] == -1) { // (왼쪽 > 오른쪽) 높이차이가 1인 경우
                for(int j = i; j < i+L; j++) { // 현재 i칸 포함 이후의 칸들 L만큼 검사
                    if(j >= N) return false; // 범위 초과
                    if(arr[j] != arr[i] || visited[j]) return false;    // 불균형, 경사로가 이미 있는 경우
                    visited[j] = true; // 경사로 설치
                }
            } else { // 높이 차이가 1이 아닌 경우 -> 실패
                return false;
            }
        }
        return true; // 위의 과정 통과 -> 설치 가능
    }
}
