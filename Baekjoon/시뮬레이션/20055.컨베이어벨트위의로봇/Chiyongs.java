package boj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 5. 5.
 * @see https://www.acmicpc.net/problem/20055
 * @performance 15716	228
 * @category #구현
 * @note
 */
public class Chiyongs {

    static int[] belt;
    static boolean[] visited;
    static int N, K, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        belt = new int[N * 2];
        visited = new boolean[N * 2]; // 로봇이 올라가있는지 확인하는 배열
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 2 * N; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        int[] upside = new int[N]; // 컨베이어 벨트에서 윗 부분
        for (int i = 1; i < N; i++) {
            upside[i] = i - 1;
        }
        upside[0] = N * 2 - 1;

        visited[upside[0]] = true;
        belt[upside[0]]--;
        if (belt[upside[0]] == 0) {
            cnt++;
        }
        int step = 1;
        while (cnt < K) { // 내구도가 0인 컨베이어가 K이상일때까지 반복
            step++;

            if (visited[upside[N - 1]]) visited[upside[N - 1]] = false; // 내려야 하는 위치일때 로봇을 내림
            for (int i = 0; i < N; i++) { // 컨베이어 벨트 회전 -> 위쪽에 나온 부분들의 숫자를 바꿔줌
                if (upside[i] == 0) upside[i] = N * 2 - 1;
                else upside[i]--;
            }

            if (visited[upside[N - 1]]) visited[upside[N - 1]] = false; // 내려야하는 위치일때 로봇 내림

            for (int i = N - 2; i >= 0; i--) { // 로봇이 움직일 수 있으면 움직이는 2번
                int cur = upside[i];
                int next = upside[i + 1];

                if (visited[cur] && !visited[next] && belt[next] > 0) { // 로봇이 앞에 없고 앞 컨베이어 내구도가 1 이상일때
                    visited[cur] = false;
                    visited[next] = true;
                    belt[next]--;
                    if (belt[next] == 0) cnt++;
                    if (next == upside[N - 1]) visited[next] = false;
                }
            }

            if (belt[upside[0]] > 0) { // 올려야하는 위치에 올릴 수 있을 때
                visited[upside[0]] = true;
                belt[upside[0]]--;
                if (belt[upside[0]] == 0) cnt++;
            }

        }

        System.out.println(step);

    }

}
