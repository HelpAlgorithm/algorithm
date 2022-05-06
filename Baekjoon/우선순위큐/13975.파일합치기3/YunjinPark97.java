package priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon13975_파일합치기3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int K = Integer.parseInt(br.readLine());
			long ans = 0;
			PriorityQueue<Long> pq = new PriorityQueue<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < K; i++) {
				pq.offer(Long.parseLong(st.nextToken()));
			}
			
			while (pq.size() >= 2) {
				long temp = pq.poll() + pq.poll();
				ans += temp;
				pq.offer(temp);
			}
			sb.append(ans+"\n");
		}
		System.out.println(sb.toString());
	}

}
