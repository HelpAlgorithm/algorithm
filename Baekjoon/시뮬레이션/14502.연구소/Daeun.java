package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class 백준_G5_연구소 {
    static int[][] map; // 바이러스가 퍼지기 전 연구소
//    static int[][] afterMap; // 기둥을 세운 후의 연구소
    static boolean[][] isVisited;
    static int N, M, maxResult;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static Queue<Point> que = new LinkedList<>();
    static ArrayList<Point> list = new ArrayList<>();
    static class Point{
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        isVisited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0){ // 0 : 빈칸이라면 Que에 저장해두기
                   list.add(new Point(i,j));
                }
            }
        }


        // (조합) list 中 빈칸을 3개 선택 -> afterMap을 만든 뒤 -> (BFS) 바이러스 확산시키기
        maxResult = Integer.MIN_VALUE;
        combination(new boolean[list.size()], 0, 0, 3);

        System.out.println(maxResult);
    }

    static void combination(boolean[] visited, int start, int depth, int end){    // 방문 여부, 시작점, 몇개 뽑았는지, 총 몇개를 뽑아야 하는지
        if(depth == end){
            maxResult = Math.max(maxResult, afterVirus(visited));
            return;
        }

        for(int i=start; i<list.size(); i++){
            if(visited[i]) continue;
            visited[i] = true;
            combination(visited, i+1, depth+1, end);
            visited[i] = false;
        }
    }

    static int afterVirus(boolean[] isVisited){

        int[][] afterMap =  new int[N][M];

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                afterMap[i][j] = map[i][j];
            }
        }
        for(int i=0; i<isVisited.length; i++){
            if(isVisited[i]){   // 해당 위치에 벽 세우기
                afterMap[list.get(i).row][list.get(i).col] = 1; 
            }
        }

        // 바이러스를 que에 넣기
        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                if(afterMap[r][c] == 2){
                    que.offer(new Point(r,c));
                }
            }
        }

        // 바이러스 확산 시키기
        boolean[][] isUsed = new boolean[N][M];
        while (!que.isEmpty()){
            Point curP = que.poll();
            int row = curP.row;
            int col = curP.col;


            for(int dir=0; dir<4; dir++){
                int nr = row + dr[dir];
                int nc = col + dc[dir];

                if(nr >= N || nc >= M || nr < 0 || nc < 0) continue; // 배열 범위 초과
                if(isUsed[nr][nc]) continue; // 이미 방문한곳 pass
                if(afterMap[nr][nc] == 1 || afterMap[nr][nc] == 2) continue; // 벽을 만나거나 바이러스를 만나면 stop\

                 // 빈칸인 경우만 전파하자
                afterMap[nr][nc] = 2;
                isUsed[nr][nc] = true;
                que.offer(new Point(nr,nc));
            }
        }

        // 확산이 끝난 뒤 남은 안전구역 세기
        int remain = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(afterMap[i][j] == 0) remain++;
            }
        }

        return remain;
    }

}
