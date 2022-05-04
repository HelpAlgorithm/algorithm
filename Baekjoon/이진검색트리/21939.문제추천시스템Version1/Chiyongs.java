package boj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Chiyongs {
	
	static class Problem implements Comparable<Problem>{
		int no, diff;
		
		public Problem(int no, int diff) {
			this.no = no;
			this.diff = diff;
		}

		@Override
		public int compareTo(Problem o2) {
			if(this.diff == o2.diff) {
				return Integer.compare(this.no, o2.no);
			}
			return Integer.compare(this.diff, o2.diff);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		TreeSet<Problem> tset = new TreeSet<>();
		TreeMap<Integer, Integer> tmap = new TreeMap<>();
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int P = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			tmap.put(P, L);
			Problem tmp = new Problem(P, L);
			tset.add(tmp);
		}
		
		int M = Integer.parseInt(br.readLine());
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			String com = st.nextToken();
			int num = Integer.parseInt(st.nextToken());
			
			if(com.equals("add")) {
				int diff = Integer.parseInt(st.nextToken());
				tmap.put(num, diff);
				Problem tmp = new Problem(num, diff);
				tset.add(tmp);
			} else if(com.equals("recommend")) {
				if(num == 1) {
					sb.append(tset.last().no).append("\n");		
				} else {
					sb.append(tset.first().no).append("\n");
				}
			} else if(com.equals("solved")) {
				tset.remove(new Problem(num, tmap.get(num)));
				tmap.remove(num);
			}
		}
		
		System.out.println(sb.toString());

	}

}
