package Baekjoon.Gold;

import java.io.*;
import java.util.*;

public class 백준_G4_11559_뿌요뿌요 {
	static char[][] map;
	static boolean[][] isVisited;
	static List<int[]> list;
	static int[] dr = {-1, 1, 0, 0}, dc= {0, 0, -1, 1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[12][6];
		
		for(int i=0; i<12; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int puyo = 0;
		while(true) {
			boolean flag = false;	// 이번 턴에 연쇄가 일어났는지 확인하는 변수
			for(int i=0; i<12; i++) {
				for(int j=0; j<6; j++) {
					if(map[i][j] != '.') {	
						char color = map[i][j];
						isVisited = new boolean[12][6];	// 매번 시행할 떄마다 새로운 visited 필요함
						list = new ArrayList<>();	// 변경한 지점 저장할 list
						int connect = bfs(j,i,color);
						if(connect >= 4) {
							flag = true;
							for(int[] change : list) {
								int cx = change[0], cy = change[1];
								map[cy][cx]	= '.';
							}
						}
					}
				}
			}
			
			if(!flag) break;	// 연쇄가 한번도 일어나지 않으면 -> 이제 끝 !!
			else puyo++;
			mapUpdate();
		}
		System.out.println(puyo);
		
	}
	
	static int bfs(int x, int y, char color) {
		Queue<int[]> que = new LinkedList<>();
		isVisited[y][x] = true;
		que.add(new int[] {x, y});
		list.add(new int[] {x,y});
		
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			
			for(int i=0; i<4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				
				if(nr<0 || nr>5 || nc<0 || nc>11) continue;	// 범위 밖
				if(isVisited[nc][nr]) continue;	// 이미 방문함
				
				if(map[nc][nr]==color) {	// 같은 색인 경우
					list.add(new int[] {nr,nc});	
					isVisited[nc][nr] = true;
					que.add(new int[] {nr,nc});
				}
			}
		}
		return list.size();
	}
	
	static void mapUpdate() {	// 연쇄이후 map 업데이트 
		Queue<Character> que = new LinkedList<>();	
		for(int i=0; i<6; i++) {	// 한줄씩 세로로 잘라서 update
			for(int j=11; j>=0; j--) {	
				if(map[j][i] != '.') que.add(map[j][i]);	// 빈칸이 아니라면 que에 담기
				map[j][i] = '.';	// 전부 다 빈칸으로 만들기
			}
			int h = 11;
			while(!que.isEmpty()) {	// que에는 해당 줄의 모든 뿌요뿌요들이 순서대로 담겨있기 떄문에, 맨 아래(row = 11)부터 한칸씩 밑으로 당겨오기 
				map[h][i] = que.poll();
				h--;	// 한줄씩 위로 당기기 
			}
		}
	}
}
