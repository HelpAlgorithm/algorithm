import java.io.*;
import java.util.*;

public class Main {
	
	static final int MAX_LEN = 100001;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int D = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		List<Pipe> pipes = new ArrayList<>();
		for (int i = 0; i < P; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			pipes.add(new Pipe(l, c));
		}
		
		Collections.sort(pipes, Collections.reverseOrder());
		int[] maxCapa = new int[MAX_LEN];
		maxCapa[0] = Integer.MAX_VALUE;
		for (Pipe p: pipes) {
			for (int i = MAX_LEN-1; i >= p.l; i--) {
				if (maxCapa[i-p.l] > 0 && maxCapa[i] < p.c) {
					maxCapa[i] = p.c;
				}
			}
		}
		System.out.println(maxCapa[D]);
	}
	
	static class Pipe implements Comparable<Pipe>{
		int l;
		int c;
		
		public Pipe(int l, int c) {
			this.l = l;
			this.c = c;
		}

		public int compareTo(Pipe o) {
			return this.c - o.c;
		}
	}

}
