package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 백준_G4_13144_ListOfUniqueNumbers {
    static int N, left, right;
    static long result;
    static int[] arr;
    static HashSet<Integer> isIn = new HashSet<>(); // 해당 숫자의 중복 여부를 체크할 hashSet사용
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        
        // 투포인터 탐색
        while(true) {
            if(right==N) {
                if(left==N) break;  // left == N : 맨 끝까지 탐색 끝
                else {
                    result += (right-left);
                    left++;
                }
            }

            else if(!isIn.contains(arr[right])) {    // hashSet에 없는 숫자면 포인터의 개수 ++
                isIn.add(arr[right]);
                right++;
            }

            else {
                result += (right-left);          // 이미 set에 해당 숫자가 있는 경우 -> 현재까지의 값 저장 
                isIn.remove(arr[left]);          // 다음 탐색을 위해 arr[left] set에서 삭제
                left++;                          // -> left+1번째 숫자부터 다시 시작
            }
        }

        System.out.println(result);
    }
}
