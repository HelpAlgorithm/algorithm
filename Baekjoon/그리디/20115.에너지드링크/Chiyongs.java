package boj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 7. 2.
 * @see https://www.acmicpc.net/problem/20115
 * @performance 27600	248
 * @category #그리디
 * @note
 */
public class BOJ_S3_20115_에너지드링크 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int[] arr = new int[N];
        int max = 0;
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(max < arr[i]) {
                max = arr[i];
            }
        }

        double sum = max;
        for(int i=0;i<N;i++) {
            if(arr[i] == max) continue;

            sum = sum + ((double)arr[i]/2);
        }

        System.out.println(sum);

    }
}
