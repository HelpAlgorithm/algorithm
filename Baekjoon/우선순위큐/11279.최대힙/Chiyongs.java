package boj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author chiyongs
 * @since 2022. 5. 5.
 * @see https://www.acmicpc.net/problem/11279
 * @performance 25320	288
 * @category #우선순위 큐
 * @note
 */
public class Chiyongs{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<N;i++) {
            int num = Integer.parseInt(br.readLine());

            if(num == 0) {
                if(pq.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(pq.poll()).append("\n");
                }
            } else {
                pq.offer(num);
            }
        }

        System.out.println(sb.toString());
    }
}
