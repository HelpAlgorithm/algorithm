package boj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 5. 5.
 * @see https://www.acmicpc.net/problem/13975
 * @performance 341008	2940
 * @category #우선순위 큐 #허프만 부호화
 * @note
 */
public class Chiyongs{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t=0;t<T;t++) {
            int K = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine()," ");

            PriorityQueue<Long> pq = new PriorityQueue<>();

            for(int i=0;i<K;i++) {
                pq.offer(Long.parseLong(st.nextToken()));
            }

            long ans = 0;
            while(pq.size()>=2) {
                long a = pq.poll();
                long b = pq.poll();

                ans += a+b;
                pq.offer(a+b);
            }

            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }
}
