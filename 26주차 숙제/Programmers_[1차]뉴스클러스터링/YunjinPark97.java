import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        Map<String, Integer> a = new HashMap<>();
        Map<String, Integer> b = new HashMap<>();
        for (int i = 0; i + 1 < str1.length(); i++) {
            if (!isAlpha(str1.charAt(i)) || !isAlpha(str1.charAt(i+1))) continue;
            a.put(str1.substring(i, i+2), a.getOrDefault(str1.substring(i, i+2), 0) + 1);
        }
        for (int i = 0; i + 1 < str2.length(); i++) {
            if (!isAlpha(str2.charAt(i)) || !isAlpha(str2.charAt(i+1))) continue;
            b.put(str2.substring(i, i+2), b.getOrDefault(str2.substring(i, i+2), 0) + 1);
        }
        int interNum = 0, unionNum = 0;
        for (String key: a.keySet()) {
            interNum += Math.min(a.get(key), b.getOrDefault(key, 0));
            unionNum += a.get(key);
        }
        for (String key: b.keySet()) {
            unionNum += b.get(key);
        }
        unionNum -= interNum;
        if (unionNum == 0) return 65536;
        int answer = (int) (65536 * ((double) interNum / unionNum));
        return answer;
    }

    boolean isAlpha(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'); 
    }
}