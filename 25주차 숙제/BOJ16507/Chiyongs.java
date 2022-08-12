package boj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 8. 12
 * @see https://www.acmicpc.net/problem/16507
 * @performance 88668	548
 * @category #DP
 * @note
 */
public class BOJ_S1_16507_어두운건무서워 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[][] picture = new int[R+1][C+1];

        for(int i=1;i<=R;i++) {
            st = new StringTokenizer(br.readLine()," ");
            for(int j=1;j<=C;j++) {
                picture[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] d = new int[R+1][C+1];
        for(int i=1;i<=R;i++) {
            for(int j=1;j<=C;j++) {
                d[i][j] = d[i-1][j] + d[i][j-1] - d[i-1][j-1] + picture[i][j];
            }
        }
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<Q;i++) {
            st = new StringTokenizer(br.readLine()," ");
            int r1 = Integer.parseInt(st.nextToken()) - 1;
            int c1 = Integer.parseInt(st.nextToken()) - 1;
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            int x = r2 - r1;
            int y = c2 - c1;

            int num = 1;
            if(x == 0) {
                num = y;
            } else if(y==0) {
                num = x;
            } else {
                num = x*y;
            }

            sb.append((d[r2][c2] - d[r1][c2] - d[r2][c1] + d[r1][c1]) / num).append("\n");
        }

        System.out.println(sb);
    }
}
