package Baekjoon.Gold;
 
import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class 백준_G4_14891_톱니바퀴 {
    static int[][] wheel;	// 톱니바퀴 N , S 저장해둘 공간
    static int K, answer;	// 회전 횟수, 정답 
    static int[] rotation;	// 회전해야하는 방향
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        wheel = new int[5][9];	// 1 ~ 5 행까지 사용
        
        for (int i = 1; i <= 4; i++) {
            input = br.readLine().split("");
            for (int j = 0; j < 8; j++) {
                wheel[i][j] = Integer.parseInt(input[j]);	// (1-N극, 2-S극)
            }
        }
        
        K = Integer.parseInt(br.readLine());  // 회전 수      
        
        for (int i = 0; i < K; i++) {
            input = br.readLine().split(" ");
            int num = Integer.parseInt(input[0]);        // 회전시킬 바퀴 번호
            int dir = Integer.parseInt(input[1]);            // 회전 방향 (1-시계방향 -1 반시계방향)
            
            rotation = new int[5];	// 회전 방향 저장해둘 배열
            rotation[num] = dir;	// num번째 dir방향으로 회전했다고 저장시켜두기
            rightCheck(num + 1, dir * -1);
            leftCheck(num - 1, dir * -1);
            // 톱니바퀴 회전 시키기
            rotate();
        }
        
        calculate();
    }
    

    private static void rotate() {
        
        for (int i = 1; i <= 4; i++) {
            // 반시계 방향 회전
            if (rotation[i] == -1) {
                int temp = wheel[i][0];	// 12시의 휠 정보 저장해두기
                for (int index = 1; index < 8; index++) {
                    wheel[i][index - 1] = wheel[i][index];
                }
                wheel[i][7] = temp;
            } 
            // 시계 방향 회전
            else if (rotation[i] == 1) {
                int temp = wheel[i][7];	// 11시의 휠 정보 저장해두기
                for (int index = 6; index >= 0; index--) {
                    wheel[i][index + 1] = wheel[i][index];
                }
                wheel[i][0] = temp;
            }
            
        }
        
    }
 
    // 현재 톱니바퀴에서 오른쪽 끝까지
    private static void rightCheck(int num, int dir) {
        if (num == 5) {	// 더이상 오른쪽 휠이 없음 -> 4번 휠인 경우
            return;
        }
        
        if (wheel[num - 1][2] != wheel[num][6]) { // 맞닿은 부분이 다르다면 회전
        	rotation[num] = dir;
            rightCheck(num + 1, dir * -1);
        }
    
    }
    
    
    // 현재 톱니바퀴에서 왼쪽 끝까지
    private static void leftCheck(int num, int dir) {
        if (num == 0) { // 더이상 왼쪽 휠이 없음 -> 1번 휠
            return;
        }
        
        if (wheel[num][2] != wheel[num + 1][6]) {	// 맞닿은 부분이 다르다면 회전
        	rotation[num] = dir;
            leftCheck(num - 1, dir * -1);
        }
    
    }
    
    private static void calculate() {
        int point = 1;	
        
        for (int i = 1; i <= 4; i++) {
            if (wheel[i][0] == 1) {	// 12시 방향의 휠이 N극(== 1)을 가리키고 있으면, answer 에 point 더하기 -> 1 , 2 , 4 , 6 , 8  
                answer += point;    
            }    
            point *= 2;
        }
        
        System.out.println(answer);
        
    }
 
    
}