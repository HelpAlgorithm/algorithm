package boj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 4. 7.
 * @see https://www.acmicpc.net/problem/11000
 * @performance 75016	708
 * @category #우선순위 큐
 * @note https://velog.io/@ss-won/PS-%EB%B0%B1%EC%A4%80-11000-%EA%B0%95%EC%9D%98%EC%8B%A4-%EB%B0%B0%EC%A0%95-%EB%AC%B8%EC%A0%9C-%ED%92%80%EC%9D%B4 * 
 */
public class BOJ_G5_11000_강의실배정 {

	static class Task implements Comparable<Task> {
		int start, end;

		public Task(int start, int end) {
			this.start = start;
			this.end = end;
		}

		public int compareTo(Task o) {
			if (this.start == o.start) {
				return this.end - o.end;
			}
			return this.start - o.start;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Task> tasks = new PriorityQueue<>();
		PriorityQueue<Integer> cr = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			tasks.offer(new Task(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		while(!tasks.isEmpty()) {
			Task cur = tasks.poll();
			if(cr.isEmpty()) {
				// 강의실 목록이 비어있다면 강의실 추가
				cr.offer(cur.end);
			} else {
				if(cur.start < cr.peek()) {
					// 현재 강의가 겹친다면
					cr.offer(cur.end);
				} else {
					// 현재 강의가 겹치지 않을 때
					cr.poll();
					cr.offer(cur.end);
				}
			}
		}
		
		System.out.println(cr.size());
		
	}
	

}
