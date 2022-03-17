package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Chiyongs {

	static char[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static List<int[]> puyos;
	static boolean[][] visited;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[12][6]; 
		
		for(int i=0;i<12;i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		
		int tot = 0;
		while(true) {
			boolean isPopp = false;
			flag = false;
			visited = new boolean[12][6];
			
			for(int r=11;r>=0;r--) {
				for(int c=0;c<6;c++) {
					if(map[r][c] != '.') {
						puyos = new ArrayList<>();
						checkBfs(r,c);
						if(puyos.size() >= 4) {
							// 상하좌우로 연결된 뿌요가 4개 이상일 때
							popp();
							isPopp = true;
						}
						flag = false;
						
					}
				}
			}
			if(!isPopp) {
				// map에서 터뜨릴 뿌요가 없을 때
				System.out.println(tot);
				return;
			} else {
				// 하나의 연쇄작용으로 생각
				tot++;
			}
			drop();
		}
		
	}
	
	private static void drop() {
		for(int c=0;c<6;c++) {
			List<Character> temp = new ArrayList<>();
			for(int r=11;r>=0;r--) {
				if(map[r][c] != '.') {
					temp.add(map[r][c]);
				}
			}
			int idx = 11;
			for(Character ch: temp) {
				map[idx--][c] = ch;
			}
			for(int i=0;i<12-temp.size();i++) {
				map[i][c] = '.';
			}
		}
	}
	
	private static void popp() {
		for(int[] puyo : puyos) {
			int r = puyo[0];
			int c = puyo[1];
			
			map[r][c] = '.';
		}
	}
	
	private static void checkBfs(int r, int c) {
		Queue<int[]> Q = new LinkedList<>();
		Q.offer(new int[] {r,c});
		visited[r][c] = true;
		puyos.add(new int[] {r,c});
		while(!Q.isEmpty()) {
			int[] cur = Q.poll();
			
			for(int d=0;d<4;d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if(nr < 0 || nc < 0 || nr>=12 || nc >= 6 || visited[nr][nc]) continue;
				if(map[nr][nc] == map[r][c]) {
					Q.offer(new int[] {nr,nc});
					visited[nr][nc] = true;
					puyos.add(new int[] {nr,nc});
				}

			}
		}
	}

}
