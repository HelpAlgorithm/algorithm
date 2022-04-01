package boj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 3. 29.
 * @see https://www.acmicpc.net/problem/14500
 * @performance 41232	752
 * @category #구현
 * @note
 */
public class BOJ_G5_14500_테트로미노 {

	static int N, M;
	static int[][] map;
	static int[][] tet1, tet2, tet3, tet4, tet5;
	static int[][] tet3_s, tet4_s;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		initTets();
		for (int ro = 0; ro < 4; ro++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					calcMax(i, j, tet1);
					calcMax(i, j, tet2);
					calcMax(i, j, tet3);
					calcMax(i, j, tet4);
					calcMax(i, j, tet5);
					calcMax(i, j, tet3_s);
					calcMax(i, j, tet4_s);
				}
			}
			tet1 = rotate(tet1);
			tet2 = rotate(tet2);
			tet3 = rotate(tet3);
			tet4 = rotate(tet4);
			tet5 = rotate(tet5);
			tet3_s = rotate(tet3_s);
			tet4_s = rotate(tet4_s);

		}

		System.out.println(answer);

	}

	private static void calcMax(int r, int c, int[][] tet) {
		int sum = 0;

		if (r + tet.length <= N && c + tet[0].length <= M) {
			for (int i = 0; i < tet.length; i++) {
				for (int j = 0; j < tet[0].length; j++) {
					if (tet[i][j] == 1) {
						sum += map[i + r][j + c];
					}
				}
			}
		}

		if (sum > answer) {
			answer = sum;
		}

	}

	private static void initTets() {
		tet1 = new int[1][4];
		for (int i = 0; i < 4; i++) {
			tet1[0][i] = 1;
		}
		tet2 = new int[2][2];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				tet2[i][j] = 1;
			}
		}
		tet3 = new int[3][2];
		tet3_s = new int[3][2];
		for (int i = 0; i < 3; i++) {
			tet3[i][0] = 1;
		}
		tet3[2][1] = 1;
		for (int i = 0; i < 3; i++) {
			tet3_s[i][1] = 1;
		}
		tet3_s[2][0] = 1;

		tet4 = new int[3][2];
		tet4[0][0] = 1;
		tet4[1][0] = 1;
		tet4[1][1] = 1;
		tet4[2][1] = 1;

		tet4_s = new int[3][2];
		tet4_s[0][1] = 1;
		tet4_s[1][0] = 1;
		tet4_s[1][1] = 1;
		tet4_s[2][0] = 1;

		tet5 = new int[2][3];
		for (int i = 0; i < 3; i++) {
			tet5[0][i] = 1;
		}
		tet5[1][1] = 1;
	}

	private static int[][] rotate(int[][] tet) {
		int n = tet.length;
		int m = tet[0].length;
		int[][] temp = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				temp[i][j] = tet[n - 1 - j][i];
			}
		}
		return temp;
	}

}
