import java.util.*;

class Solution {
    static List<Integer> nums = new ArrayList<Integer>();
    static int[] input;
    static int N;
    static boolean[] visited;
    
    public int solution(String numbers) {
        HashSet<Integer> set = new HashSet<Integer>();
        int answer = 0;
        N = numbers.length();
        input = new int[N];
        for (int i = 0; i < N; i++){
            input[i] = numbers.charAt(i) - '0';
        }
        Arrays.sort(input);
        
        for (int l = 1; l <= N; l++){
            visited = new boolean[N];
            perm(0, l, 0);
        }
        
        //System.out.println(nums.toString());
        for (int num: nums){
            if (set.contains(num)) continue;
            set.add(num);
            if (isPrime(num)) answer++;    
        }

        return answer;
    }
    
    static boolean isPrime(int n){
        if (n <= 1) return false;
        for (int i = 2; i <= (int) Math.pow(n, 0.5); i++){
            if (n%i == 0) return false;
        }
        return true;
    }
    
    static void perm(int count, int length, int temp){
        if (count == length){
            nums.add(temp);
            return;
        }
        
        for (int i = 0; i < N; i++){
            if (visited[i]) continue;
            visited[i] = true;
            perm(count+1, length, temp*10 + input[i]);
            visited[i] = false;
        }
    }
    
}