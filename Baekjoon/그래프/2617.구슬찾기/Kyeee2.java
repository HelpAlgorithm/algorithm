import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Kyeee2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, M;
	static List<List<Integer>> up = new ArrayList<>();   // 무거운거
	static List<List<Integer>> down = new ArrayList<>(); // 가벼운거

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());

		for(int i = 0; i <= N; i++) {
			up.add(new ArrayList<>());
			down.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			tokens = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(tokens.nextToken());
			int n2 = Integer.parseInt(tokens.nextToken());
			
			// n1이 n2보다 무겁다
			up.get(n2).add(n1);
			down.get(n1).add(n2);
		}
		
		int result = 0;
		for(int i = 1; i <= N; i++) {		
			// 무거운거 개수 세기
			if(countUp(i) > N / 2) result++;
			// 가벼운거 개수 세기
			else if(countDown(i) > N / 2) result++;
		}
		
		System.out.println(result);
	}

	private static int countDown(int n) {
		Queue<Integer> Q = new LinkedList<>();
		boolean [] visited = new boolean [N + 1];
		
		Q.offer(n);
		visited[n] = true;
		int cnt = 0;
		while(!Q.isEmpty()) {
			int now = Q.poll();
			cnt++;
			
			for(int i = 0; i < down.get(now).size(); i++) {
				if(visited[down.get(now).get(i)]) continue;
				
				Q.offer(down.get(now).get(i));
				visited[down.get(now).get(i)] = true;
			}
		}
		return cnt - 1; // 자기 자신 빼기
	}

	private static int countUp(int n) {
		Queue<Integer> Q = new LinkedList<>();
		boolean [] visited = new boolean [N + 1];
		
		Q.offer(n);
		visited[n] = true;
		int cnt = 0;
		while(!Q.isEmpty()) {
			int now = Q.poll();
			cnt++;
			
			for(int i = 0; i < up.get(now).size(); i++) {
				if(visited[up.get(now).get(i)]) continue;
				
				Q.offer(up.get(now).get(i));
				visited[up.get(now).get(i)] = true;
			}
		}
		return cnt - 1; // 자기 자신 빼기
	}

}
