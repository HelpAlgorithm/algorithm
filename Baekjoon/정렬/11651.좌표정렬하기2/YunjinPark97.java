package sorting;


/*
 * 1) 주어진 (a, b)에 대하여 1000000*b + a해서 sort하는 방법도 있음
 * 2) 이런 문제를 위하여 람다식 사용법이 익숙해질 필요가 있음: ->{}
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon11651_좌표정렬하기2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] coords = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			coords[i][0] = Integer.parseInt(st.nextToken());
			coords[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(coords, (e1, e2)->{
			if (e1[1] == e2[1]) {
				return Integer.compare(e1[0], e2[0]);
			}
			return Integer.compare(e1[1], e2[1]);
		});
		for (int i = 0; i < n; i++) {
			sb.append(coords[i][0]+ " " + coords[i][1]+"\n");
		}
		System.out.println(sb);
	}

}
