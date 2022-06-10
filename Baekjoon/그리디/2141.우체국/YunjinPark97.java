package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon2141_우체국 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Town> towns = new ArrayList<>();
		long totalPpl = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int loc = Integer.parseInt(st.nextToken());
			int ppl = Integer.parseInt(st.nextToken());
			totalPpl += ppl;
			towns.add(new Town(loc, ppl));
		}
		Collections.sort(towns);
		long curPpl = 0;
		int ans = 0;
		for (int i = 0; i < towns.size(); i++) {
			curPpl += towns.get(i).ppl;
			if (curPpl >= (totalPpl+1)/2) {
				ans = towns.get(i).loc;
				break;
			}
		}
		System.out.println(ans);
	}
	
	
	static class Town implements Comparable<Town>{
		int loc;
		int ppl;
		
		public Town(int loc, int ppl) {
			this.loc = loc;
			this.ppl = ppl;
		}

		public int compareTo(Town o) {
			return Integer.compare(this.loc, o.loc);
		}
	}

}
