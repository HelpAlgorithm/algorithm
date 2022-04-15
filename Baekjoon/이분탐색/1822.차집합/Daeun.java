package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_S4_1822_차집합 {
    static int N, M;
    static HashSet<Integer> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            int b = Integer.parseInt(st.nextToken());
            if(set.contains(b))
                set.remove(b);
        }

        System.out.println(set.size());

        ArrayList list = new ArrayList(set);
        Collections.sort(list);  // collectionSort가 Arrays.sort보다 빠르다

        for(int i=0; i<list.size(); i++)
            System.out.print(list.get(i)+" ");
    }
}
