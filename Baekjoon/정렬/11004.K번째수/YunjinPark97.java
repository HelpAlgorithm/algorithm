package sorting;

/*
 * 아무리 생각해도 다 정렬하는건 비효율적
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon11004_K번째수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		List<Integer> nums = new ArrayList<Integer>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(nums);
		System.out.println(nums.get(k-1));
	}

}
