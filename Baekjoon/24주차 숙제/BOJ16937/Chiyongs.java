package boj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 7. 30.
 * @see https://www.acmicpc.net/problem/16937
 * @performance 11800	84
 * @category #완전탐색
 * @note
 */
public class BOJ_S3_16937_스티커 {

    static int N, H, W, result;
    static int[] isSelected = new int[2];
    static int[][] stickers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        N = Integer.parseInt(br.readLine());
        stickers = new int[N][2];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine()," ");
            stickers[i][0] = Integer.parseInt(st.nextToken());
            stickers[i][1] = Integer.parseInt(st.nextToken());
        }

        choose(0,0);
        System.out.println(result);

    }

    static void choose(int cnt, int start) {
        if(cnt == 2) {
            int x1 = stickers[isSelected[0]][0];
            int x2 = stickers[isSelected[1]][0];
            int y1 = stickers[isSelected[0]][1];
            int y2 = stickers[isSelected[1]][1];

            // x축을 W, y축을 H로 해서 두 개의 스티커에 대한 모든 경우
            if ((x1 <= W && x2 <= W && y1 + y2 <= H)
                    || (x1 <= W && y2 <= W && y1 + x2 <= H)
                    || (y1 <= W && x2 <= W && x1 + y2 <= H)
                    || (y1 <= W && y2 <= W && x1 + x2 <= H)) {
                int tmp = (x1 * y1) + (x2 * y2);
                if (tmp > result) result = tmp;
            }
            // x축을 H, y축을 W로 해서 두 개의 스티커에 대한 모든 경우
            if ((x1 <= H && x2 <= H && y1 + y2 <= W)
                    || (x1 <= H && y2 <= H && y1 + x2 <= W)
                    || (y1 <= H && x2 <= H && x1 + y2 <= W)
                    || (y1 <= H && y2 <= H && x1 + x2 <= W)) {
                int tmp = (x1 * y1) + (x2 * y2);
                if (tmp > result) result = tmp;
            }
            return;
        }

        for(int i=start;i<N;i++) {
            isSelected[cnt] = i;
            choose(cnt+1, i+1);
        }
    }
}
