package Baekjoon.Silver;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_S1_14888_연산자끼워넣기 {
    static int N, MAX, MIN;
    static int[] nums, operators;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        nums = new int[N];
        operators = new int[4];

        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<4;i++) { // 연산자 입력
            operators[i] = Integer.parseInt(st.nextToken());
        }

        MAX = Integer.MIN_VALUE;
        MIN = Integer.MAX_VALUE;

        calculate(nums[0], 1);

        System.out.println(MAX);
        System.out.println(MIN);
    }

    private static void calculate(int sum, int index){
        if(index == N){// 최대, 최소값 갱신
            if(sum > MAX){
                MAX = sum;
            }
            if(sum < MIN){
                MIN = sum;
            }
            return;
        }

        int curSum = 0; // 현재까지의 값 저장

        for(int i=0; i<4; i++){
            if(operators[i] != 0){
                operators[i]--; // i번째 연산자 하나 사용
                
                switch(i){  // 사칙연산
                    case 0:
                        curSum = sum + nums[index];
                        break;
                    case 1:
                        curSum = sum - nums[index];
                        break;
                    case 2:
                        curSum = sum * nums[index];
                        break;
                    case 3:
                        if(curSum < 0 && nums[index] > 0){// 음수 % 양수
                            curSum = (Math.abs(sum) / nums[index]) * -1;
                        }else{
                            curSum = sum / nums[index];
                        }
                        break;
                }
                calculate(curSum, index+1); // 다음 연산 진행
                operators[i]++; // 원상복구
            }
        }
    }
}
