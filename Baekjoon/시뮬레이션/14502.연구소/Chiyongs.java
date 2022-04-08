package boj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 4. 2.
 * @see https://www.acmicpc.net/problem/14502
 * @performance 124604	416
 * @category #구현 #BFS #조합
 * @note 벽을 세울 수 있는 세 곳을 조합을 통해 선택한 후 BFS를 진행
 *       -> 각 분기마다 안전영역의 크기를 계산 -> 최대 값 출력
 */
public class BOJ_G5_14502_연구소 {
	
	static class Point {
		int r, c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int comb_size,N,M,answer;
	static List<Point> points,virus;
	static Point[] selected = new Point[3];
	static int[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		virus = new ArrayList<>();
		points = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++) {
				int th = Integer.parseInt(st.nextToken());
				if(th == 2) {
					virus.add(new Point(i,j));
				} else if(th==0) {
					points.add(new Point(i,j));
				}
				map[i][j] = th;
			}
		}
		
		comb_size = points.size();
		
		comb(0,0);
		
		System.out.println(answer);	

	}
	
	private static void comb(int cnt, int start) {
		if(cnt==3) {
			map[selected[0].r][selected[0].c]= 1; 
			map[selected[1].r][selected[1].c]= 1; 
			map[selected[2].r][selected[2].c]= 1;
			
			Queue<Point> Q = new LinkedList<>();
			boolean[][] visited = new boolean[N][M];
			for(Point v : virus) {
				Q.offer(v);
				visited[v.r][v.c]= true; 
			}
			
			while(!Q.isEmpty()) {
				Point cur = Q.poll();
				
				for(int d=0;d<4;d++) {
					int nr = cur.r+dr[d];
					int nc = cur.c+dc[d];
					
					if(nr<0||nc<0||nr>=N||nc>=M||visited[nr][nc]||map[nr][nc]!=0) continue;
					
					Q.offer(new Point(nr,nc));
					visited[nr][nc] =true;
				}
			}
			int count = 0;
			for(int r=0;r<N;r++) {
				for(int c=0;c<M;c++) {
					if(!visited[r][c] && map[r][c] == 0) {
						count++;
					}
				}
			}
			
			if(answer < count) {
				answer = count;
			}
			
			map[selected[0].r][selected[0].c]= 0; 
			map[selected[1].r][selected[1].c]= 0; 
			map[selected[2].r][selected[2].c]= 0;
			
			return;
			
		}
		
		for(int i=start;i<comb_size;i++) {
			selected[cnt] = points.get(i);
			comb(cnt+1,i+1);
		}
	}

}
