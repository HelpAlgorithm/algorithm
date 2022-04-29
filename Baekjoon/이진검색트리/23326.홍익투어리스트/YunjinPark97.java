import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		int cur = 0;
		
		TreeSet<Integer> famous = new TreeSet<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			if (Integer.parseInt(st.nextToken()) == 1) famous.add(i);
		}
		
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			if (command == 3) {
				if (famous.isEmpty()) sb.append("-1\n");
				else if (famous.ceiling(cur) == null) {
					sb.append(N-cur+famous.ceiling(0)+"\n");
				} else {
					sb.append(famous.ceiling(cur)-cur+"\n");
				}
			} else {
				if (command == 2) {
					cur = (cur + Integer.parseInt(st.nextToken())) % N;
				} else {
					int loc = Integer.parseInt(st.nextToken())-1;
					if (famous.contains(loc)) famous.remove(loc);
					else famous.add(loc);
				}
			}
		}
		System.out.println(sb.toString());
	}

}
