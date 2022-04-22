package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 백준_S4_17219_비밀번호찾기 {
    static int N, M;
    static Map<String, String> site = new HashMap<>(); // url, password 입력될 hash map

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // input
        for (int count = 0; count < N; count++) {
            st = new StringTokenizer(br.readLine());
            site.put(st.nextToken(),st.nextToken());
        }


        for(int i=0; i<M; i++) {
            String findUrl = br.readLine();
            sb.append(site.get(findUrl)+"\n");
        }
        System.out.println(sb.toString());
    }

}
