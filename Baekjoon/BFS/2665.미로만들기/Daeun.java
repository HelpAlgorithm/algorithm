
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Daeun {
    /*  solution
     *   최소한의 검은방만 흰 방으로 바꿔서 (1,1) (N,N)이 이어지게끔 하면 된다.
     *   최대한 적은 방만 변경 -> isVisited를 boolean이 아닌 int(현재까지 변경한 방의 개수)로 설정해서
     *   1. isVisited[이동하려는 칸][이동하려는 칸] <= 현재 칸의 값 : 갱신 시키고 이동
     *   2. isVisited[이동하려는 칸][이동하려는 칸] > 현재 칸의 값 : 이동 X (이미 더 많이 변경하는 경우이기 때문)
     * */

    static class Move {
        int row, col, cnt, color;
        public Move(int row, int col, int cnt, int color) {
            this.row = row;
            this.col = col;
            this.cnt = cnt;
            this.color = color;
        }
    }

    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,1,0,-1};
    static int[][]map;
    static int[][]visit;
    static int N= Integer.MAX_VALUE;
    static Queue<Move>q= new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());

        map= new int[N][N];
        visit= new int[N][N];

        for (int i = 0; i <N; i++) {
            char[] input = br.readLine().toCharArray(); // char 배열로 쫘라락 받기
            for (int k = 0; k <N; k++) {
                map[i][k] = input[k]-'0';   // 숫자로 바꾸기
                visit[i][k] = Integer.MAX_VALUE;
            }
        }
        // que에 추가
        q.add(new Move(0,0,0,0));

        bfs();
        System.out.println(visit[N-1][N-1]); // 끝방에 최종적으로 남은 숫자 -> 최소 방을 변경하며 도착한 경우

    }
    private static void bfs() {

        visit[0][0] = 0;
        while(!q.isEmpty()) {
            Move move =q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = move.row +dx[i];
                int ny = move.col +dy[i];

                if(nx< 0 || nx >=N|| ny < 0 || ny >=N) continue;

                // 방문할 곳이 자기가 바꾼 횟수보다 작거나 같은 경우 (가지치기)
                if(visit[nx][ny] <= move.color) continue;
                // 검은방일 때
                if(map[nx][ny] == 0) {
                    visit[nx][ny] = move.color+1;
                    q.add(new Move(nx,ny, move.cnt+1, move.color+1));
                }
                // 흰방일 때
                else if(map[nx][ny] == 1) {
                    visit[nx][ny] = move.color;
                    q.add(new Move(nx,ny, move.cnt+1, move.color));
                }
            }
        }
    }
}
