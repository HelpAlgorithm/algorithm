package boj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author chiyongs
 * @since 2022. 7. 4.
 * @see https://www.acmicpc.net/problem/2665
 * @performance 13240	100
 * @category #BFS #다익스트라
 * @note
 */
public class BOJ_G4_2665_미로만들기 {

    static int n, map[][], distance[][], darkmap[][];
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        distance = new int[n][n];


        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                int val = line.charAt(j) - '0';
                map[i][j] = val;
                distance[i][j] = Integer.MAX_VALUE;
            }
        }

        bfs();
        System.out.println(distance[n-1][n-1]);

    }

    static void bfs() {
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[]{0,0});
        distance[0][0] = 0;

        while (!Q.isEmpty()) {
            int[] cur = Q.poll();

            for(int d=0;d<4;d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if(nr < 0 || nc < 0 || nr >= n || nc >= n) continue;

                if(distance[nr][nc] > distance[cur[0]][cur[1]]) {
                    if(map[nr][nc] == 1) {
                        distance[nr][nc] = distance[cur[0]][cur[1]];
                    } else {
                        distance[nr][nc] = distance[cur[0]][cur[1]]+1;
                    }
                    Q.offer(new int[]{nr,nc});
                }
            }
        }
    }
}
