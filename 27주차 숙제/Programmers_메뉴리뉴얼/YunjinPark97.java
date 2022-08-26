import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        // 0. freq의 i번째 index에 '길이가 i인 메뉴들의 등장 빈도'를 저장
        List<HashMap<String, Integer>> freq = new ArrayList<HashMap<String, Integer>>();
        for (int i = 0; i < 11; i++) {
            freq.add(new HashMap<>());
        }

        // 1. 가능한 메뉴 조합을 모두 넣기
        for (String order: orders) {
            int len = order.length();
            for (int i = 1; i < (1 << len); i++) {
                char[] food = order.toCharArray();
                Arrays.sort(food);
                int temp = i;
                String menu = "";
                for (int j = 0; j < len; j++) {
                    if ((temp & 1) == 1) menu += food[j];
                    temp /= 2;
                }
                freq.get(menu.length()).put(menu, freq.get(menu.length()).getOrDefault(menu, 0) + 1);
            }
        }

        // 2. 각 길이별로 최대 등장을 찾고, 넣어줌
        List<String> list = new ArrayList<>();
        for (int len: course) {
            int maxFreq = 2;
            Set<String> tempSet = new HashSet<>();
            for (String key: freq.get(len).keySet()) {
                int tempFreq = freq.get(len).get(key);
                if (tempFreq == maxFreq) {
                    tempSet.add(key);
                } else if (tempFreq > maxFreq) {
                    tempSet.clear();
                    maxFreq = tempFreq;
                    tempSet.add(key);
                }
            }

            for (String menu: tempSet) {
                list.add(menu);
            }
        }

        Collections.sort(list);
        return list.toArray(new String[0]);
    }
}