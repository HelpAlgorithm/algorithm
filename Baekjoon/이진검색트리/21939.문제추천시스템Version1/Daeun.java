package Baekjoon.Gold;

import java.util.*;

public class 백준_G4_21939_문제추천시스템 {
    static TreeSet<Problem> treeSet = new TreeSet<>();
    static Map<Integer,Integer> map = new HashMap<>();
    static int N,M;

    static class Problem implements Comparable<Problem> {
        int index;
        int level;

        public Problem(int index, int level) {
            this.index = index;
            this.level = level;
        }
        // 동일한 난이도 -> 문제 순으로 정렬
        public int compareTo(Problem o) {

            if (level ==  o.level) {
                return index - o.index;
            } else {
                return level - o.level;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        int index, level;
        for (int i = 0; i < N; i++) {
            index = sc.nextInt();
            level = sc.nextInt();
            treeSet.add(new Problem(index, level));
            map.put(index,level);
        }

        M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            String command = sc.next(   );
            if (command.equals("add")) {    // 추천 문제 리스트에 난이도가 level인 문제 번호 index를 추가한다.
                index = sc.nextInt();
                level = sc.nextInt();
                treeSet.add(new Problem(index, level));
                map.put(index,level);
            } else {
                if (command.equals("recommend")) {  // recommend 명령이 주어질 때마다 문제 번호를 한 줄씩 출력
                    if (sc.nextInt() == 1) {
                        System.out.println(treeSet.last().index);
                    } else {
                        System.out.println(treeSet.first().index);
                    }
                } else if(command.equals("solved")) {   // 추천 문제 리스트에서 문제 번호 curIndex를 제거한다.
                    int curIndex = sc.nextInt();
                    treeSet.remove(new Problem(curIndex,map.get(curIndex)));
                    map.remove(curIndex);
                }
            }
        }
    }
}
