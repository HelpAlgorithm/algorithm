package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baekjoon13414_수강신청 {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> hMap = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		String[] std = new String[L];
		for (int i = 0; i < L; i++) {
			String str = br.readLine();
			if (!hMap.containsKey(str)) {
				std[i] = str;
				hMap.put(str, i);
			} else {
				std[hMap.get(str)] = null;
				std[i] = str;
				hMap.put(str, i);
			}
		}
		
		int idx = 0;
		while (K-- > 0) {
			while (idx < L && std[idx] == null) {
				idx++;
			}
            if (idx >= L) break;
			sb.append(std[idx]+"\n");
			idx++;
		}
		
		System.out.println(sb.toString());
	}

}
