package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class 백준_G5_11000_강의실배정 {
    static int N;
    static ArrayList<Lecture> list = new ArrayList<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    static class Lecture implements Comparable<Lecture>{
        int start;
        int end;

        public Lecture(int start, int e) {
            super();
            this.start = start;
            this.end = e;
        }

        // 시작 시간이 빠른 순으로 정렬
        // 시작 시간이 동일한 경우 -> 종료 시간이 빠른 강의가 앞쪽에 배치
        @Override
        public int compareTo(Lecture o) {
            if(o.start ==this.start) {
                return this.end -o.end;
            }
            return this.start -o.start;
        }

    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(list); // 정렬

        pq.add(list.get(0).end);    // 첫번째 강의 배정
        for (int i = 1; i < N; i++) {
            if(list.get(i).start >=pq.peek()) {  // 아직 강의가 진행중이라면 que는 비어있지 않음
                pq.poll(); // 현재 강의의 시작 시간(어떤 강의의 종료 시간일 수도 있음) <= 이후 강의의 끝나는 시간 -> 강의실 하나로 두 강의를 해결할 수 있음 => poll
            }
            pq.add(list.get(i).end);   // que에 남아있는 값이 종료 시간이어야 다음 시작시간과 비교할 수 있으므로
        }
        System.out.println(pq.size()); // priority queue 의 size == 모든 강의를 배정했을 때, 다른 강의실에서 진행중인 강의들의 합
    }
  
}

