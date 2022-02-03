package algorithm_practice.Baekjoon.Sort;

import java.io.*;
import java.util.*;

/*시간을 줄이려면 퀵정렬로 구현하면 된다고 함*/

public class Sort_2_11004 {
    public static int n;
    public static int k;
    public static long[] arr;
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new long[n];
 
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
 
        Arrays.sort(arr);
        System.out.println(arr[k - 1]);
    }
}
