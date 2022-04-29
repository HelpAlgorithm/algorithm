import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TreeSet<Problem> tSet = new TreeSet<>();
		TreeMap<Integer, Integer> numDiff = new TreeMap<>();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int diff = Integer.parseInt(st.nextToken());
			numDiff.put(num, diff);
			tSet.add(new Problem(num, diff));
		}
		
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			int num = Integer.parseInt(st.nextToken());
			if (command.equals("add")) {
				int diff = Integer.parseInt(st.nextToken());
				numDiff.put(num, diff);
				tSet.add(new Problem(num, diff));
			}
			else if (command.equals("recommend")) {
				if (num == 1) {
					sb.append(tSet.last().num+"\n");
				} else {
					sb.append(tSet.first().num+"\n");
				}
			} 
			else {
				int diff = numDiff.get(num);
				numDiff.remove(num);
				tSet.remove(new Problem(num, diff));
			}
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
	}
	
	
	static class Problem implements Comparable<Problem> {
		int num;
		int diff;
		
		public Problem(int num, int diff) {
			super();
			this.num = num;
			this.diff = diff;
		}

		@Override
		public int compareTo(Problem o) {
			if (this.diff == o.diff) {
				return Integer.compare(this.num, o.num);
			}
			return Integer.compare(this.diff, o.diff);
		}
		
//		@Override
//		public boolean equals(Object o) {
//			Problem p = (Problem) o;
//			return this.diff == p.diff && this.num == p.num;
//		}		
	}

}
