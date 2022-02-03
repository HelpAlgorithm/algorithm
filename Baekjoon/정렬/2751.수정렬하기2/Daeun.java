package algorithm_practice.Baekjoon.Sort;

import java.io.*;
import java.util.*;

public class Sort_2_2751 {
 
    public static int N;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
 

        ArrayList<Integer> arr = new ArrayList<>();
        N = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(br.readLine()));
 
        }
        Collections.sort(arr);
        
        for (int i : arr) {
            sb.append(i).append('\n');
        }
        System.out.println(sb);
    }
 
}
