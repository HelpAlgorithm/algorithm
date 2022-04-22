import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Kyeee2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, min = Integer.MAX_VALUE;
	static int [][] map;
	static boolean [] selected;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		N = Integer.parseInt(br.readLine());
		map = new int [N][N];
		for(int r = 0; r < N; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		selected = new boolean[N];
		
		selectTeam(0, 0);

		System.out.println(min);
	}

	private static void selectTeam(int cnt, int start) {
		if(cnt == N/2) {
			int [] team1 = new int [N/2];
			int [] team2 = new int [N/2];
			int ind1 = 0, ind2 = 0;
			for(int i = 0; i < N; i++) {
				if(selected[i]) team1[ind1++] = i;
				else			team2[ind2++] = i;
			}
			
			int sum1 = sumAbility(team1);
			int sum2 = sumAbility(team2);
			int diff = Math.abs(sum1 - sum2);
			
			min = Math.min(min, diff);
			
			return;
		}
		
		for(int i = start; i < N; i++) {
			selected[i] = true;
			selectTeam(cnt + 1, i + 1);
			selected[i] = false;
		}
	}

	private static int sumAbility(int[] team) {
		int sum = 0;
		for(int i = 0; i < N / 2; i++) {
			for(int j = i + 1; j < N / 2; j++) {
				sum += map[team[i]][team[j]];
				sum += map[team[j]][team[i]];
			}
		}
		return sum;
	}

}
