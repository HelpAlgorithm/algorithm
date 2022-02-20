import java.util.*;

class Solution {
    
    int N;
    char [] nums;
    Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        nums = numbers.toCharArray();
        N = nums.length;
        
        makeNumber(0, "", 0);
        
        return set.size();
    }
    
    // 정수 n이 소수인지 판별
    private boolean isPrime(int n) {
        if(n <= 1) return false;
        
        for(int i = 2; i * i <= n; i++) {
            if(n % i == 0) return false;
        }
        
        return true;
    }
    
    private void makeNumber(int cnt, String num, int bits) {
        if(cnt == N) {
            if(num.equals("")) return; // 빈문자열은 무시
            
            int n = Integer.parseInt(num);
            if(isPrime(n)) set.add(n);
            return;
        }
        
        for(int i = 0; i < N; i++) {
            if((bits & (1 << i)) != 0) continue;
            
            makeNumber(cnt + 1, num + nums[i], bits | (1 << i)); // 현재 숫자를 추가
            makeNumber(cnt + 1, num, bits | (1 << i)); // 현재 숫자를 추가하지 않음
        }
    }
}