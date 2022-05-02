package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 백준_S3_13414_수강신청 {
    static int K, N, student;
    static Map<String, Integer> map = new LinkedHashMap<>(); // LinkedHashMap를 이용해 들어온 순서대로 저장
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if(map.getOrDefault(str, 0) == 1)  // 이미 대기열에 있는데 수강신청 버튼을 다시 누른경우 -> 대기열 맨뒤로  (애도를 표합니다..)
                map.remove(str); // map에서 제거한 뒤
            map.put(str, 1);    // 맨뒤로 보내기
        }

        student = 0; // 총 K명만 수강신청 성공!
        for (String code : map.keySet()) {   // 3명의 학번 출력
            if(student++ == K) break;
            System.out.println(code);
        }
    }
}

