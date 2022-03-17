import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Kyeee2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static char [][] map = new char [12][6]; // 필드
	static boolean [][] visited;			 // 필드 방문 여부
	static int [] dr = {1, 0, -1, 0}, dc = {0, 1, 0, -1};
	static List<Point> points;
	
	static class Point {
		int r, c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// 필드 설정
		for(int r = 0; r < 12; r++) {
			String line = br.readLine();
			for(int c = 0; c < 6; c++) {
				map[r][c] = line.charAt(c);
			}
		}
		
		int time = 0;
		while(true) {
			visited = new boolean [12][6];
			
			boolean flag = true; // 뿌요가 하나라도 터졌는가?
			for(int r = 0; r < 12; r++) {
				for(int c = 0; c < 6; c++) {
					if(map[r][c] == '.' || visited[r][c]) continue;
					
					findGroup(r, c);
					
					// 4개 이상 같은 뿌요가 있다면
					if(points.size() >= 4) {
						flag = false;
						
						for(int i = 0; i < points.size(); i++) {
							map[points.get(i).r][points.get(i).c] = '.';
						}
					}
				}
			}
			
			if(flag) break;
			
			time++;
			changeField();
		}
		
		System.out.println(time);

	}

	// 같은 뿌요 그룹 찾기
	private static void findGroup(int r, int c) {
		points = new ArrayList<>();
		
		Queue<Point> Q = new LinkedList<>();
		Q.offer(new Point(r, c));
		points.add(new Point(r, c));
		visited[r][c] = true;
		
		while(!Q.isEmpty()) {
			Point now = Q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nr = now.r + dr[i];
				int nc = now.c + dc[i];
				
				if(nr < 0 || nr >= 12 || nc < 0 || nc >= 6 || map[nr][nc] != map[r][c] || visited[nr][nc]) continue;
				
				Q.offer(new Point(nr, nc));
				points.add(new Point(nr, nc));
				visited[nr][nc] = true;
			}
		}
	}

	// 찾은 뿌요 그룹 지우기
	private static void changeField() {
		for(int c = 0; c < 6; c++) {
			Queue<Character> Q = new LinkedList<>();
			for(int r = 11; r >= 0; r--) {
				if(map[r][c] != '.') {
					Q.offer(map[r][c]);
				}
			}
			
			for(int r = 11; r >= 0; r--) {
				if(Q.isEmpty()) map[r][c] = '.';
				else			map[r][c] = Q.poll();
			}
		}
	}

}
