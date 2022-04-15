package boj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 4. 14.
 * @see https://www.acmicpc.net/problem/2003
 * @performance 14300	108	
 * @category #투포인터
 * @note
 */
public class BOJ_S3_2003_수들의합2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = 0;
		
		int answer = 0;
		int result = nums[0];
		while(start <= end && end < N) {
			if(start== end) {
				if(nums[start] == M) { 
					// 하나의 수를 바라보고 있으면서 M일때 정답갯수 늘리고 시작과 끝 위치 모두 증가
					answer++;
					if(end == N-1) break; // 마지막 원소이면 더 볼 필요 없으므로 탈출
					result -= nums[start];
					start++;
					end++;
					result += nums[start];
				} else {
					// 하나의 수를 바라보고 있지만 M이 아니면 끝 위치를 증가시켜서 범위 증가
					if(end == N-1) break; // 마지막 원소이면 더 볼 필요 없으므로 탈출
					end++;
					result += nums[end];
				}
			} else {
				if(result == M) {
					// 지금 보는 범위의 합이 M이면 시작 위치 증가 -> 범위 축소
					result -= nums[start];
					answer++;
					start++;
				} else if(result > M) {
					// 지금 보는 범위의 합이 M보다 크면 시작 위치 증가 -> 범위 축소
					result -= nums[start];
					start++;
				} else {
					// 지금 보는 범위의 합이 M보다 작으면 끝 위치 증가 -> 범위 증가
					if(end == N-1) break; // 마지막 원소가 포함된 범위인데 M보다 작으므로 더 볼 필요 없음
					end++;
					result += nums[end];
				}
			}
		}
		
		
		System.out.println(answer);

	}

}
