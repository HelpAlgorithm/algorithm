package boj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 4. 20.
 * @see https://www.acmicpc.net/problem/13414
 * @performance 70860	624
 * @category #해시
 * @note LinkedHashSet은 입력 순서가 보장된다.
 */
public class BOJ_S3_13414_수강신청 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		int K = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		Set<String> set = new LinkedHashSet<>();
		for(int i=0;i<L;i++) {
			String input = br.readLine();
			if(set.contains(input)) {
				set.remove(input);
			}
			set.add(input);
		}
		
		for(String sn : set) {
			if(--K<0) break;
			sb.append(sn).append("\n");
		}
		
		System.out.println(sb.toString());

	}

}
