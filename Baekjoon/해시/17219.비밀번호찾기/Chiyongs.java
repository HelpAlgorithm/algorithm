package boj.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 4. 21.
 * @see https://www.acmicpc.net/problem/17219
 * @performance 63184	520
 * @category #해시
 * @note 많은 데이터 중에서 원하는 걸 찾을 땐 hashmap
 */
public class BOJ_S4_17219_비밀번호찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, String> map = new HashMap<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			map.put(st.nextToken(), st.nextToken());
		}
		
		for(int i=0;i<M;i++) {
			sb.append(map.get(br.readLine())).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
