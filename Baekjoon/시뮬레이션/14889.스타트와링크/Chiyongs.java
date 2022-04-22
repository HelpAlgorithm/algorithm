package boj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 4. 16.
 * @see https://www.acmicpc.net/problem/14889
 * @performance 15868	236	
 * @category #구현
 * @note 20C10을 통해 팀을 나누고 최소 구하기
 */
public class BOJ_S2_14889_스타트와링크 {

	static int N, map[][],input[], start[], link[];
	static boolean[] isSelected;
	static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		input = new int[N];
		start = new int[N/2];
		link = new int[N/2];
		isSelected = new boolean[N];
		answer = Integer.MAX_VALUE;
		
		for(int i=0;i <N;i++) {
			input[i] = i;
		}

		comb(0,0);
		
		System.out.println(answer);
	}
	
	private static int calc(int[] team) {
		int sum = 0;
		for(int i=0;i<N/2;i++) {
			for(int j=0;j<N/2;j++) {
				sum += map[team[i]][team[j]];
			}
		}
		return sum;
	}

	private static void comb(int cnt, int st) {
		if (cnt == N / 2) {
			int idx = 0;
			for(int i=0;i<N;i++) {
				if(!isSelected[i]) {
					link[idx++] = i;
				}
			}
			int st_sum = calc(start);
			int li_sum = calc(link);
			
			if(answer > Math.abs(st_sum - li_sum)) {
				answer = Math.abs(st_sum - li_sum);
			}
			return;
		}
		
		for(int i=st;i<N;i++) {
			start[cnt] = input[i];
			isSelected[input[i]] = true;
			comb(cnt+1, i+1);
			isSelected[input[i]] = false;
		}
	}

}
