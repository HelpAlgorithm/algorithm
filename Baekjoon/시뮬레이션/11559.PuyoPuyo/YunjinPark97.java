import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

/*
 * 복잡하긴한데 조건대로 구현하면 edge case 등은 없는듯?
 * 디버깅도 편함
 */
public class Baekjoon11559_PuyoPuyo {
	static char[][] field;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		field = new char[12][6];
		for (int i = 0; i < 12; i++) {
			String str = br.readLine();
			for (int j = 0; j < 6; j++) {
				field[i][j] = str.charAt(j);
			}
		}
		
		int chain = 0;
		while (puyoBoom()) {
			chain++;
			arrangeField();
		}
		System.out.println(chain);
	}
	
	static boolean puyoBoom() {
		boolean isBoom = false;
		boolean[][] visited = new boolean[12][6];
		Queue<int[]> queue = new ArrayDeque<>();
		Queue<int[]> queueStore = new ArrayDeque<>();
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 6; j++) {
				if (field[i][j] == '.' || visited[i][j]) {
					visited[i][j] = true;
					continue;
				}
				
				visited[i][j] = true;
				char tempPuyo = field[i][j];
				queue.offer(new int[] {i, j});
				queueStore.offer(new int[] {i ,j});
				while (!queue.isEmpty()) {
					int[] temp = queue.poll();
					int r = temp[0], c = temp[1];
					for (int dir = 0; dir < 4; dir++) {
						int nr = r + dr[dir], nc = c + dc[dir];
						if (nr < 0 || nr >= 12 || nc < 0 || nc >= 6) continue;
						if (visited[nr][nc] || field[nr][nc] != tempPuyo) continue;
						visited[nr][nc] = true;
						queue.offer(new int[] {nr, nc});
						queueStore.offer(new int[] {nr, nc});
					}
				}
				if (queueStore.size() >= 4) {
					isBoom = true;
					while (!queueStore.isEmpty()) {
						int[] temp = queueStore.poll();
						field[temp[0]][temp[1]] = '.';
					}
				}
				else {
					queueStore.clear();
				}
			}
		}
		
		return isBoom;
	}
	
	
	
	static void arrangeField() {
		for (int c = 0; c < 6; c++) {
			int targetRow = 11, currRow = 11;
			while (currRow >= 0) {
				if (field[currRow][c] == '.') {
					currRow--;
				}
				else {
					char puyo = field[currRow][c];
					field[currRow--][c] = '.';
					field[targetRow--][c] = puyo;
				}
			}
		}

		return;
	}

}








