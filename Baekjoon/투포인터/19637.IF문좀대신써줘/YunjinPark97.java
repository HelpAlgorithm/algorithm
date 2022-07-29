import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] powers = new int[N];
		String[] titles = new String[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			titles[i] = st.nextToken();
			powers[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < M; i++) {
			int l = 0, r = N-1;
			int power = Integer.parseInt(br.readLine());
			while (l <= r) {
				int mid = (l+r) / 2;
				if (powers[mid] < power) {
					l = mid + 1;
				} else {
					r = mid - 1;
				}
			}
			sb.append(titles[l]+"\n");
		}
		System.out.println(sb.toString());
	}
}
