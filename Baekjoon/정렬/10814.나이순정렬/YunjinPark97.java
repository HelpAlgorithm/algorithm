package sorting;

/* 
 * 2번째 요소로 정렬 + 내가 쓰는 sorting 알고리즘이 stable한지 인지
 * quicksort는 unstable
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon10814_나이순정렬 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[][] memberInfo = new String[n][2];
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			memberInfo[i][0] = st.nextToken();
			memberInfo[i][1] = st.nextToken();
		}
		Arrays.sort(memberInfo, (e1, e2)->{
			return Integer.compare(Integer.parseInt(e1[0]), Integer.parseInt(e2[0]));
		});
		for (int i = 0; i < n; i++) {
			sb.append(memberInfo[i][0] + " " + memberInfo[i][1] + "\n");
		}
		System.out.println(sb);
	}
}
