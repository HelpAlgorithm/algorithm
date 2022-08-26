package programmers.카카오.블라인드채용2021.메뉴리뉴얼;

import java.util.*;

class Solution {

    static char[] comp;
    static String[] orderList;
    static Map<Integer, Map<String, Integer>> map;
    static int[] len;
    static Set<String> set;

    public String[] solution(String[] orders, int[] course) {
        orderList = new String[orders.length];
        len = new int[11];
        map = new HashMap<>();

        for(String order : orders) {
            for(int c : course) {
                comp = new char[c];
                set = new HashSet<>();
                if(c <= order.length()) choose(order, 0, 0, c, orders);
            }
        }

        List<String> answer = new ArrayList<>();

        for(Integer l : map.keySet()) {
            List<String> temp = new ArrayList<>();

            Map<String, Integer> tmap = map.get(l);
            int max = 2;
            for(String s : tmap.keySet()) {

                if(max < tmap.get(s)) {
                    temp = new ArrayList<>();
                    temp.add(s);
                    max = tmap.get(s);
                } else if(max == tmap.get(s)) temp.add(s);
            }

            answer.addAll(temp);
        }

        Collections.sort(answer);

        return answer.toArray(new String[0]);
    }

    public void choose(String order, int cnt, int start, int n, String[] orders) {
        if(cnt == n) {
            char[] copy = Arrays.copyOf(comp, comp.length);
            Arrays.sort(copy);
            String temp = String.valueOf(copy);

            for(String o : orders) {
                int count = 0;
                for(int i=0;i<comp.length;i++) {
                    if(o.contains(String.valueOf(comp[i]))) {
                        count++;
                    }
                }
                if(count == n) {
                    Map<String,Integer> kv = map.getOrDefault(comp.length, new HashMap<>());
                    int num = kv.getOrDefault(temp, 0);
                    kv.put(temp, num+1);
                    map.put(temp.length(), kv);
                    return;
                }
            }
            return;
        }

        for(int i=start;i<order.length();i++) {
            comp[cnt] = order.charAt(i);
            choose(order, cnt+1, i+1, n, orders);
        }
    }
}