package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon10825_국영수 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		String[][] students = new String[n][4];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				students[i][j] = st.nextToken();
			}
		}
		Arrays.sort(students, (e1, e2)->{
			if (e1[1].equals(e2[1])) {
				if (e1[2].equals(e2[2])) {
					if (e1[3].equals(e2[3])) {
						return e1[0].compareTo(e2[0]);
					}
					return Integer.compare(Integer.parseInt(e1[3]), Integer.parseInt(e2[3])) * -1;
				}
				return Integer.compare(Integer.parseInt(e1[2]), Integer.parseInt(e2[2]));
			}
			return Integer.compare(Integer.parseInt(e1[1]), Integer.parseInt(e2[1])) * -1;
		});
		for (int i = 0; i < n; i++) {
			sb.append(students[i][0]+"\n");
		}
		System.out.println(sb);
	}
}
