import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Kyeee2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, K, k, result;
	static int [] belt, idx;
	static boolean [] robot;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken()) * 2;
		K = Integer.parseInt(tokens.nextToken());
		
		belt = new int [N];
		robot = new boolean [N];
		idx = new int [N / 2];
		tokens = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			belt[i] = Integer.parseInt(tokens.nextToken());
			if(belt[i] == 0) k++;
		}
		for(int i = 0; i < N / 2; i++) {
			idx[i] = i;
		}
		
		result = 0;
		while(k < K) {
			result++;
			
			// 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
			if(robot[idx[N / 2 - 1]]) robot[idx[N / 2 - 1]] = false;
			for(int i = 0; i < N / 2; i++) {
				idx[i] = (idx[i] + N - 1) % N;
			}
			
			// 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동
			// 이동 불가능하면 가만히
			for(int i = N / 2 - 1; i >= 0; i--) {
				if(i == N / 2 - 1) {
					if(robot[idx[i]]) robot[idx[i]] = false;
				}
				else {
					if(robot[idx[i]]) {
						if(robot[idx[i + 1]] || belt[idx[i + 1]] == 0) continue;
						robot[idx[i + 1]] = true;
						belt[idx[i + 1]]--;
						robot[idx[i]] = false;
						if(belt[idx[i + 1]] == 0) k++;
					}
				}
			}
			
			// 올리는 위치에 있는 칸의 내구도가 0이 아니라면 로봇 올리기
			if(belt[idx[0]] > 0) {
				robot[idx[0]] = true;
				belt[idx[0]]--;
				if(belt[idx[0]] == 0) k++;
			}
		}
		System.out.println(result);
	}

}
