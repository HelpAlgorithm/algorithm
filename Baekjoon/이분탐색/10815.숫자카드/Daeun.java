package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_S4_10815_숫자카드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());

        int[] arr = new int[size];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);   // 이분탐색 하기전 정렬

        size = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        while(size --> 0) {
            sb.append(binarySearch(arr, 0, arr.length - 1, Integer.parseInt(st.nextToken()))).append(" ");
        }
        System.out.print(sb);

        // 숫자가 있는지 없는지 확인만 하면 되므로 -> HashSet으로 해결 가능할듯? 굳이 이분탐색 안해도?
    }

    public static int binarySearch(int[] arr, int start, int end, int n) { // 이분탐색
        while(start <= end) {
            int mid = (start + end) / 2;

            if(arr[mid] == n) {
                return 1;
            }

            if(n < arr[mid]) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return 0;
    }
}
