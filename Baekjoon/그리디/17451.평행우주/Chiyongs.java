package boj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 7. 24.
 * @see https://www.acmicpc.net/problem/17451
 * @performance 58180	344
 * @category #그리디
 * @note
 */
public class BOJ_S3_17451_평행우주 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long[] arr = new long[n];
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long speed = arr[n-1];
        // 가장 맨 뒤 속도로 앞으로 온다고 생각하면서 속도를 올리면 최솟값
        for(int i=n-2;i>=0;i--) {
            if(arr[i] >= speed) speed = arr[i]; // 앞 행성이 필요 속도가 더 높으면 속도 증가
            else {
                if(speed % arr[i] == 0) continue; // 앞 행성이 필요 속도가 더 작은데 배수면 속도 유지
                else {
                    // 앞 행성이 필요 속도가 더 작은데 배수가 아니면
                    // 앞 행성에서 가능한 속도의 최솟값을 구함
                    speed = (speed / arr[i]) * arr[i] + arr[i];
                }
            }
        }

        System.out.println(speed);
    }
}
